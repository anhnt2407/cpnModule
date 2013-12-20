/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class Subset {
    
    private String id="";
    private With with;
    private Ml by;

    public Subset() {
        with = new With();
        by = new Ml();
    }

    public Ml getBy() {
        return by;
    }

    public void setBy(Ml by) {
        this.by = by;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public With getWith() {
        return with;
    }

    public void setWith(With with) {
        this.with = with;
    }
    
    
    
    
    
}
