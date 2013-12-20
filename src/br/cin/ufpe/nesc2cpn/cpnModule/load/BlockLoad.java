package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.globbox.Block;
import br.cin.ufpe.nesc2cpn.cpnModule.globbox.BlockItem;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avld
 */
public class BlockLoad extends CpnItemLoad
{
    protected Block block;

    public BlockLoad(Node node)
    {
        super( node );
    }

    public Block getBlock()
    {
        block = new Block( null );
        block.setId( getID() );
        
        block.setItemList( getBlockItemList() );
        return block;
    }

    protected List<BlockItem> getBlockItemList()
    {
        List<BlockItem> itemList = new ArrayList<BlockItem>();

        NodeList nodeList = node.getChildNodes();
        for( int i = 0 ; i < nodeList.getLength() ; i++ )
        {
            Node children = nodeList.item( i );

            if( "id".equalsIgnoreCase( children.getNodeName() )
                    && block != null )
            {
                block.setNameId( getText( children ) );
            }
            else
            {
                BlockItem item = getBlockItem( children );

                if( item != null )
                {
                    itemList.add( item );
                }
            }
        }

        return itemList;
    }

    public BlockItem getBlockItem( Node node )
    {
        if( "var".equalsIgnoreCase( node.getNodeName() ) )
        {
            VarLoad load = new VarLoad( node );
            return load.getVar();
        }
        else if( "block".equalsIgnoreCase( node.getNodeName() ) )
        {
            BlockLoad load = new BlockLoad( node );
            return load.getBlock();
        }
        else if( "color".equalsIgnoreCase( node.getNodeName() ) )
        {
            ColorLoad load = new ColorLoad( node );
            return load.getColor();
        }
        else if( "globref".equalsIgnoreCase( node.getNodeName() ) )
        {
            GlobrefLoad load = new GlobrefLoad( node );
            return load.getGlobref();
        }
        else if( "ml".equalsIgnoreCase( node.getNodeName() ) )
        {
            MlLoad load = new MlLoad( node );
            return load.getMl();
        }
        else if( "with".equalsIgnoreCase( node.getNodeName() ) )
        {
            return null;
        }
        else
        {
            return null;
        }
    }

}
