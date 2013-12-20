package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.Arc;
import org.w3c.dom.Node;

/**
 *
 * @author avld
 */
public class ArcLoad extends CpnItemLoad
{
    private Arc arc;

    public ArcLoad(Node node)
    {
        super( new Arc() , node );
        arc = (Arc) cpnItem;
    }

    public Arc getArc()
    {
        return (Arc) getCpnItem();
    }

    @Override
    public void foundExtraAttr( Node n )
    {
        if( "orientation".equals( n.getNodeName() ) )
        {
            arc.setOrientation( n.getNodeValue() );
        }
        else if("order".equals(n.getNodeName()))
        {
            int value = Integer.parseInt( n.getNodeValue() );
            arc.setOrder( value );
        }
    }

    @Override
    public void foundExtraNode( Node n )
    {
        if( "transend".equals( n.getNodeName() ) )
        {
            arc.setTransendIdref( getIdRef( n ) );
        }
        else if( "placeend".equals( n.getNodeName() ) )
        {
            arc.setPlaceendIdref( getIdRef( n ) );
        }
        else if( "annot".equals( n.getNodeName() ) )
        {
            CpnItemLoad load = new CpnItemLoad( n );
            arc.setAnnot( load.getCpnItem() );
        }
        else if( "bendpoint".equals( n.getNodeName() ) )
        {
            CpnItemLoad load = new CpnItemLoad( n );
            arc.getBendpointList().add( load.getCpnItem() );
        }
    }

    public long getIdRef( Node node )
    {
        Node idNode = node.getAttributes().getNamedItem( "idref" );
        String idStr = idNode.getNodeValue().substring( 2 );

        return Integer.parseInt( idStr );
    }
}
