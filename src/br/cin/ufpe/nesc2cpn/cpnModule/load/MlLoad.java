package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.globbox.Ml;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avld
 */
public class MlLoad extends BlockItemLoad
{

    public MlLoad(Node node)
    {
        super( node );
    }

    public Ml getMl()
    {
        Ml ml = new Ml();
        ml.setId( getID() );

        NodeList list = node.getChildNodes();
        for( int i = 0 ; i < list.getLength() ; i++ )
        {
            Node children = list.item( i );
            
            if( "layout".equalsIgnoreCase( children.getNodeName() ) )
            {
                ml.setLayout( getText( children ) );
            }
        }

        return ml;
    }
}
