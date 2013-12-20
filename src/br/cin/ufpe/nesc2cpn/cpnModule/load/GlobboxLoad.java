package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.globbox.BlockItem;
import java.util.List;
import org.w3c.dom.Node;

/**
 *
 * @author avld
 */
public class GlobboxLoad extends BlockLoad
{
    public GlobboxLoad(Node node)
    {
        super( node );
    }

    public List<BlockItem> getGlobBox()
    {
        return getBlockItemList();
    }
}
