package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.globbox.Var;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avld
 */
public class VarLoad extends BlockItemLoad
{
    
    public VarLoad( Node node )
    {
        super( node );
    }

    public Var getVar()
    {
        Var var = new Var();
        var.setId( getID() );

        NodeList list = node.getChildNodes();
        for( int i = 0 ; i < list.getLength() ; i++ )
        {
            Node children = list.item( i );
            
            if( "layout".equalsIgnoreCase( children.getNodeName() ) )
            {
                var.setLayout( getText( children ) );
            }
            if( "id".equalsIgnoreCase( children.getNodeName() ) )
            {
                var.getNameIdList().add( getText( children ) );
            }
            if( "type".equalsIgnoreCase( children.getNodeName() ) )
            {
                var.setTypeIdList( getListId( children ) );
            }
        }

        return var;
    }

}
