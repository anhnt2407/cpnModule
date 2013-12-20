package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.globbox.GlobRef;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avld
 */
public class GlobrefLoad extends CpnItemLoad
{
    
    public GlobrefLoad(Node node)
    {
        super( node );
    }

    public GlobRef getGlobref()
    {
        GlobRef ref = new GlobRef();
        ref.setId( getID() );
        
        NodeList list = node.getChildNodes();
        for( int i = 0; i < list.getLength(); i++ )
        {
            Node nodeChildren = list.item( i );

            if( "id".equalsIgnoreCase( nodeChildren.getNodeName() ) )
            {
                ref.setNameId( getText( nodeChildren ) );
            }
            else if("ml".equalsIgnoreCase(nodeChildren.getNodeName()))
            {
                ref.setMl( getText( nodeChildren ) );
            }
            else if("layout".equalsIgnoreCase(nodeChildren.getNodeName()))
            {
                ref.setLayout( getText( nodeChildren ) );
            }
        }

        return ref;
    }

}
