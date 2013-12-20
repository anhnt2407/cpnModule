package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class Lister {
    
    private With with;
    private String id;
    
    public Lister()
    {
        
    }

    public Lister(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public With getWith()
    {
        return with;
    }

    public void setWith(With with)
    {
        this.with = with;
    }
}
