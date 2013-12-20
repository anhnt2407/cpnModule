package br.cin.ufpe.nesc2cpn.cpnModule;

/**
 *
 * @author avld
 */
public class IDControl {
    public static IDControl instance;

    private long itemCounter;
    
    private long transCounter;
    private long arcCounter;
    private long placeCounter;

    private long forCounter;

    private IDControl()
    {
        reset();
    }

    public static IDControl getInstance()
    {
        if( instance == null )
        {
            instance = new IDControl();
        }

        return instance;
    }

    public void reset()
    {
        itemCounter = 1000;
        transCounter = 0;
        arcCounter = 0;
        placeCounter = 0;
    }

    // -------------------------------- //
    // -------------------------------- //
    // -------------------------------- //

    public long getItemNextId() {
        return ++itemCounter;
    }

    public long getArcNextId() {
        return ++arcCounter;
    }

    public long getPlaceNextId() {
        return ++placeCounter;
    }

    public long getTransNextId() {
        return ++transCounter;
    }

    public long getForNextId() {
        return ++forCounter;
    }

    // -------------------------------- //
    // -------------------------------- //
    // -------------------------------- //

    public long getItemCounter() {
        return itemCounter;
    }

    public long getArcCounter() {
        return arcCounter;
    }

    public long getPlaceCounter() {
        return placeCounter;
    }

    public long getTransCounter() {
        return transCounter;
    }

    public long getForCounter() {
        return forCounter;
    }
    
}
