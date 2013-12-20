/*
<!ELEMENT globbox   (%decls;)*>

<!ENTITY % decls "block | color | var | ml | globref | use">


<!ELEMENT block     (id, (%decls;)*)>
<!ATTLIST block     id          ID          #IMPLIED>

<!ELEMENT color     (id, declare?, timed?, (unit | bool | int | real | string |
                                            enum | index | product | record | list |
                                            union | alias | subset)*, layout?)>
<!ATTLIST color     id          ID          #IMPLIED>

<!ELEMENT var       (type, id+, layout?)>
<!ATTLIST var       id          ID          #IMPLIED>

<!ELEMENT ml        (#PCDATA | layout)*>
<!ATTLIST ml        id          ID          #IMPLIED>


<!ELEMENT globref   (id?, ml?, layout?)>
<!ATTLIST globref   id     ID          #IMPLIED>

<!ELEMENT use	    (ml, layout)>
<!ATTLIST use	    id          ID          #IMPLIED>



<!ELEMENT declare   (id)+>
<!ELEMENT timed     EMPTY>
<!ELEMENT unit      (with)?>
<!ELEMENT bool      (with)?>
<!ELEMENT int       (with)?>
<!ELEMENT real      (with)?>
<!ELEMENT string    (with)?>
<!ELEMENT enum      (id)+>
<!ELEMENT index     (ml, ml, id)>
<!ELEMENT product   (id)+>

<!ELEMENT record    (recordfield)+>

<!ELEMENT recordfield (id,id)>


<!ELEMENT list      ((with)?, id)>

<!ELEMENT union     (unionfield)+>

<!ELEMENT unionfield (id, (type)?)>

<!ELEMENT alias     (id)?>
<!ELEMENT subset    (id?, (with | by))>

<!ELEMENT layout    (#PCDATA)>


<!ATTLIST type      id          ID          #IMPLIED>

<!ELEMENT id        (#PCDATA)>



<!ELEMENT with      ((ml, (ml?|and))|(id,(id)?))>


<!ELEMENT and       (ml)+>

 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davi
 */
public class Block extends BlockItem
{
    private List<BlockItem> itemList;
    
    public Block( String name )
    {
        setNameId( name );
        itemList = new ArrayList<BlockItem>();
    }

    public void add(BlockItem item)
    {
        itemList.add( item );
    }

    public List<BlockItem> getItemList()
    {
        return itemList;
    }

    public void setItemList(List<BlockItem> itemList)
    {
        this.itemList = itemList;
    }

    @Override
    public String toString()
    {
        String txt = "block: " + getNameId() + "\n";

        for( BlockItem item : getItemList() )
        {
            txt += " " + item.toString() + "\n";
        }

        return txt;
    }
}
