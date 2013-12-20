/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davi
 */
public class With
{
    private Ml ml;
    private List<Ml> listMl;
    private String id1;
    private String id2;

    public With()
    {
        listMl = new ArrayList<Ml>();
    }

    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }

    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }

    public List<Ml> getListMl() {
        return listMl;
    }

    public void setListMl(List<Ml> listMl) {
        this.listMl = listMl;
    }

    public Ml getMl() {
        return ml;
    }

    public void setMl(Ml ml) {
        this.ml = ml;
    }
}
