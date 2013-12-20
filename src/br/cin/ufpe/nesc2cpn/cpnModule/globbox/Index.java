/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class Index {
    
    private Ml ml1;
    private Ml ml2;
    private String id;
    
    public Index(){
        
        ml1 = new Ml();
        ml2 = new Ml();
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Ml getMl1() {
        return ml1;
    }

    public void setMl1(Ml ml1) {
        this.ml1 = ml1;
    }

    public Ml getMl2() {
        return ml2;
    }

    public void setMl2(Ml ml2) {
        this.ml2 = ml2;
    }
    
}
