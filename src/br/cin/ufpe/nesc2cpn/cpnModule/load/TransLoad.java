package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.Trans;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avld
 */
public class TransLoad extends CpnItemLoad
{
    private Trans trans;
    
    public TransLoad(Node node)
    {
        super( new Trans() , node );
        trans = (Trans) cpnItem;
    }

    public Trans getTrans()
    {
        return (Trans) getCpnItem();
    }

    @Override
    public void foundExtraAttr( Node n )
    {
        if( "explicit".equals( n.getNodeName() ) )
        {
            boolean value = Boolean.parseBoolean( n.getNodeValue() );
            trans.setTransExplicit( value );
        }
    }

    @Override
    public void foundExtraNode( Node n )
    {
        if( "box".equals( n.getNodeName() ) )
        {
            double[] values = getBox( n );

            trans.setBoxW( values[0] );
            trans.setBoxH( values[1] );
        }
        else if( "binding".equals( n.getNodeName() ) )
        {
            double[] values = getBinding( n );

            trans.setBindingX( values[0] );
            trans.setBindingY( values[1] );
        }
        else if( "cond".equals( n.getNodeName() ) )
        {
            CpnItemLoad load = new CpnItemLoad( n );
            trans.setCond( load.getCpnItem() );
        }
        else if( "subst".equals( n.getNodeName() ) )
        {
            setSubst( n );
        }
        else if( "time".equals( n.getNodeName() ) )
        {
            CpnItemLoad load = new CpnItemLoad( n );
            trans.setTime( load.getCpnItem() );
        }
        else if( "code".equals( n.getNodeName() ) )
        {
            CpnItemLoad load = new CpnItemLoad( n );
            trans.setCode( load.getCpnItem() );
        }
        else if( "channel".equals( n.getNodeName() ) )
        {
            CpnItemLoad load = new CpnItemLoad( n );
            trans.setChannel( load.getCpnItem() );
        }
        else if( "priority".equals( n.getNodeName() ) )
        {
            CpnItemLoad load = new CpnItemLoad( n );
            trans.setPriority( load.getCpnItem() );
        }
    }


    public double[] getBox(Node node)
    {
        double[] values = new double[2];

        //"<box w="" h=""/>
        Node wNode = node.getAttributes().getNamedItem( "w" );
        values[0] = Double.parseDouble( wNode.getNodeValue().replace( "," , "." ) );

        Node hNode = node.getAttributes().getNamedItem( "h" );
        values[1] = Double.parseDouble( hNode.getNodeValue().replace( "," , "." ) );

        return values;
    }

    public double[] getBinding(Node node)
    {
        double[] values = new double[2];

        //"<binding x="" y=""/>
        Node xNode = node.getAttributes().getNamedItem( "x" );
        values[0] = Double.parseDouble( xNode.getNodeValue().replace( "," , "." ) );

        Node yNode = node.getAttributes().getNamedItem( "y" );
        values[1] = Double.parseDouble( yNode.getNodeValue().replace( "," , "." ) );

        return values;
    }
    
    private void setSubst( Node node )
    {
        NodeList list = node.getChildNodes();
    
        String portSocketId = node.getAttributes().getNamedItem("subpage").getNodeValue();
        trans.setPortsockId( Integer.parseInt( portSocketId.substring( 2 ) ) );
        
        for( Entry<Long,List<Long>> entry : getPortSocket( node ).entrySet() )
        {
            for( long id : entry.getValue() )
            {
                trans.addPortsock( entry.getKey() , id );
            }
        }
        
        for( int i = 0 ; i < list.getLength() ; i++ )
        {
            Node n = list.item( i );
            
            if( "subpageinfo".equals( n.getNodeName() ) )
            {
                CpnItemLoad load = new CpnItemLoad( n );
                trans.setSubpageinfo( load.getCpnItem() );
                trans.getSubpageinfo().setText( n.getAttributes().getNamedItem("name").getNodeValue() );
            }
        }
    }
    
    private Map<Long,List<Long>> getPortSocket( Node node )
    {
        Map<Long,List<Long>> map = new HashMap<Long, List<Long>>();
        String portSocket = node.getAttributes().getNamedItem("portsock").getNodeValue();
        
        portSocket = portSocket.replaceAll( Pattern.quote( ")(" ) , ";" );
        portSocket = portSocket.replaceAll( Pattern.quote( ")" ) , " " );
        portSocket = portSocket.replaceAll( Pattern.quote( "(" ) , " " );
        portSocket = portSocket.trim();
        
        String part[] = portSocket.split( ";" );
        for( String p : part )
        {
            String value[] = p.split( "," );
            long id1 = Integer.parseInt( value[0].substring( 2 ) );
            long id2 = Integer.parseInt( value[1].substring( 2 ) );
            
            if( !map.containsKey( id2 ) )
            {
                map.put( id2 , new ArrayList<Long>() );
            }
            
            map.get( id2 ).add( id1 );
        }
        
        return map;
    }
    
}
