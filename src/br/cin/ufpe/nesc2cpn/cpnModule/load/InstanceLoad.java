package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.instances.InstanceItens;
import br.cin.ufpe.nesc2cpn.cpnModule.instances.TransItens;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avld
 */
public class InstanceLoad
{
    private InstanceItens instanceItens;
    private TransItens transItens;
    private Node node;
    
    public InstanceLoad( Node node )
    {
        this.node = node;
    }
    
    public InstanceItens getInstanceItens()
    {
        return processInstanceItens();
    }
    
    private InstanceItens processInstanceItens()
    {
        String id = node.getAttributes().getNamedItem( "id" ).getNodeValue();
        String pageId = node.getAttributes().getNamedItem( "page" ).getNodeValue();
        
        instanceItens = new InstanceItens();
        instanceItens.setInstanceId( Integer.parseInt( id.substring( 2 ) ) );
        instanceItens.setInstancePage( Integer.parseInt( pageId.substring( 2 ) ) );
        
        NodeList list = node.getChildNodes();
        for( int i = 0; i < list.getLength() ; i++ )
        {
            Node n = list.item( i );
            
            if( "instance".equalsIgnoreCase( n.getNodeName() ) )
            {
                InstanceLoad loader = new InstanceLoad( n );
                instanceItens.getInstanceTrans().add( loader.getTransItens() );
            }
        }
        
        return instanceItens;
    }
    
    // ------------------------------ //
    // ------------------------------ //
    // ------------------------------ //
    
    public TransItens getTransItens()
    {
        return processTransItens();
    }
    
    private TransItens processTransItens()
    {
        String id = node.getAttributes().getNamedItem( "id" ).getNodeValue();
        String pageId = node.getAttributes().getNamedItem( "trans" ).getNodeValue();
        
        transItens = new TransItens( 0 );
        transItens.setTransItensId( Integer.parseInt( id.substring( 2 ) ) );
        transItens.setTransItensTrans(Integer.parseInt( pageId.substring( 2 ) ) );
        
        NodeList list = node.getChildNodes();
        for( int i = 0; i < list.getLength() ; i++ )
        {
            Node n = list.item( i );
            
            if( "instance".equalsIgnoreCase( n.getNodeName() ) )
            {
                InstanceLoad loader = new InstanceLoad( n );
                transItens.getTransItensList().add( loader.getTransItens() );
            }
        }
        
        return transItens;
    }
}
