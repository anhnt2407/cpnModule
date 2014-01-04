/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.monitorblock;

import br.cin.ufpe.nesc2cpn.cpnModule.IDControl;
import br.cin.ufpe.nesc2cpn.cpnModule.globbox.Ml;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Davi
 */
public class Monitor
{
    private long    id;
    private String  name                = "monitorName";
    private int     type                = 1;
    private String  typeDescription     = "monitorTypeDescription";
    private boolean Disable             = false;
    
    private Map<Long,Long> node;
    private List<Ml>   declaration;
    private Map<String,Object> option;
    
    public Monitor()
    {
        id = IDControl.getInstance().getItemNextId();
        
        node = new HashMap<Long, Long>();
        declaration = new ArrayList<Ml>();
        option = new HashMap<String, Object>();
    }

    public boolean isDisable() {
        return Disable;
    }

    public void setDisable(boolean Disable) {
        this.Disable = Disable;
    }

    public List<Ml> getDeclaration()
    {
        return declaration;
    }

    public void setDeclaration(List<Ml> declaration)
    {
        this.declaration = declaration;
    }

    public void setDeclaration(Ml function)
    {
        this.declaration = new ArrayList<Ml>();
        this.declaration.add( function );
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

    public Map<Long, Long> getNode() {
        return node;
    }

    public void setNode(Map<Long, Long> node) {
        this.node = node;
    }
    
    public void setNode(long transID , long pageID )
    {
        this.node = new HashMap<Long, Long>();
        this.node.put( transID , pageID );
    }

    public Map<String, Object> getOption() {
        return option;
    }

    public void setOption(Map<String, Object> option) {
        this.option = option;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

}
