package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.IndexNode.IndexNode;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avld
 */
public class IndexNodeLoad extends CpnItemLoad
{
    
    public IndexNodeLoad(Node node)
    {
        super( node );
    }

    public IndexNode getIndexNode()
    {
        return getIndexNode( node );
    }

    private IndexNode getIndexNode( Node node )
    {
        Node expandedNode = node.getAttributes().getNamedItem( "expanded" );
        String value = expandedNode.getNodeValue();

        IndexNode index = new IndexNode();
        index.setIndexNodeExpanded( Boolean.parseBoolean( value ) );

        NodeList list = node.getChildNodes();
        
        for( int i = 0; i < list.getLength(); i++ )
        {
            Node children = list.item( i );

            if( "IndexNode".equalsIgnoreCase( children.getNodeName() ) )
            {
                IndexNode childrenIndex = getIndexNode( children );
                index.getIndexNode().add( childrenIndex );
            }
        }

        return index;
    }
}
