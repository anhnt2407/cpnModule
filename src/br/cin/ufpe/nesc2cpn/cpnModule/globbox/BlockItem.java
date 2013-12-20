
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

import br.cin.ufpe.nesc2cpn.cpnModule.IDControl;

/**
 *
 * @author Davi
 */
public class BlockItem
{
    private long id;
    private String nameId;
    private String layout;
    
    public BlockItem()
    {
        id = IDControl.getInstance().getItemNextId();
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public String getLayout()
    {
        return layout;
    }

    public void setLayout(String layout)
    {
        this.layout = layout;
    }

    public String getNameId()
    {
        return nameId;
    }

    public void setNameId(String nameId)
    {
        this.nameId = nameId;
    }
    
}
