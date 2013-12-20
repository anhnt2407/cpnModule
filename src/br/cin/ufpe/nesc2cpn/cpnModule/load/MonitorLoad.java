package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.monitorblock.Monitor;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avld
 */
public class MonitorLoad
{
    private Node node;
    private Monitor monitor;
    
    public MonitorLoad( Node node )
    {
        this.node = node;
    }
        
    public Monitor getMonitor()
    {
        monitor = new Monitor();
        
        String id = node.getAttributes().getNamedItem( "id" ).getNodeValue();
        monitor.setId( Long.parseLong( id.substring( 2 ) ) );
        
        String name =  node.getAttributes().getNamedItem( "name" ).getNodeValue();
        monitor.setName( name );
        
        String type = node.getAttributes().getNamedItem( "type" ).getNodeValue();
        monitor.setType( Integer.parseInt( type ) );
        
        String typeDesc = node.getAttributes().getNamedItem( "typedescription" ).getNodeValue();
        monitor.setTypeDescription( typeDesc );
        
        String disabled = node.getAttributes().getNamedItem( "disabled" ).getNodeValue();
        monitor.setDisable(Boolean.parseBoolean( disabled ) );
        
        NodeList list = node.getChildNodes();
        for( int i = 0 ; i < list.getLength() ; i++ )
        {
            Node n = list.item( i );
            
            if( "node".equalsIgnoreCase( n.getNodeName() ) )
            {
                setNode( n );
            }
            else if( "declaration".equalsIgnoreCase( n.getNodeName() ) )
            {
                setMl( n );
            }
        }
        
        return monitor;
    }
    
    private void setNode( Node node )
    {
        String id = node.getAttributes().getNamedItem( "idref" ).getNodeValue();
        String pageid = node.getAttributes().getNamedItem( "pageinstanceidref" ).getNodeValue();
        
        monitor.setNode( Long.parseLong( id.substring( 2 ) ) 
                       , Long.parseLong( pageid.substring( 2 ) ) );
    }
    
    private void setMl( Node node )
    {
        NodeList list = node.getChildNodes();
        for( int i = 0 ; i < list.getLength() ; i++ )
        {
            Node n = list.item( i );
            
            if( "ml".equalsIgnoreCase( n.getNodeName() ) )
            {
                MlLoad mlLoader = new MlLoad( n );
                monitor.setDeclaration( mlLoader.getMl() );
            }
        }
    }
}
