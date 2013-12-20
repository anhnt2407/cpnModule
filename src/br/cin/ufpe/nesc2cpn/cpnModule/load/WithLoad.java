package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.globbox.With;
import org.w3c.dom.Node;

/**
 *
 * @author avld
 */
public class WithLoad extends CpnItemLoad
{

    public WithLoad( Node node )
    {
        super( node );
    }

    public With getWith()
    {
        With with = new With();
        
        return with;
    }
}
