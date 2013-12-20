package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author avld
 */
public class RecordField
{
    private String id;
    private String type;

    public RecordField()
    {
        // do nothing
    }

    public RecordField(String id, String type)
    {
        this.id = id;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
}
