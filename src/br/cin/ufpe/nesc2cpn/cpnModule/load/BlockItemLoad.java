package br.cin.ufpe.nesc2cpn.cpnModule.load;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avld
 */
public class BlockItemLoad extends CpnItemLoad
{

    public BlockItemLoad(Node node)
    {
        super( node );
    }

    public List<String> getListId(Node node)
    {
        List<String> list = new ArrayList<String>();

        NodeList nodeList = node.getChildNodes();
        for( int i = 0 ; i < nodeList.getLength() ; i++ )
        {
            Node children = nodeList.item( i );

            if( "id".equalsIgnoreCase( children.getNodeName() ) )
            {
                list.add( getText( children ) );
            }
        }

        return list;
    }

}
