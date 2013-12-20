
package br.cin.ufpe.nesc2cpn.cpnModule.group;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davi
 */
public class Group {
    
    private long id;
    private String name;
    private List<String> groupElmIdref;
    //private List<> iuiui;
    
    public Group(){
        
        groupElmIdref = new ArrayList<String>();
        //this.name = name;
        
    }
    
    

    public List<String> getGroupElmIdref() {
        return groupElmIdref;
    }

    public void setGroupElmIdref(List<String> groupElmIdref) {
        this.groupElmIdref = groupElmIdref;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
