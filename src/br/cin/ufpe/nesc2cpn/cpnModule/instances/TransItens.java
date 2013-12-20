/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.instances;

import br.cin.ufpe.nesc2cpn.cpnModule.IDControl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davi
 */
public class TransItens
{
    private long transItensId;
    private long transItensTrans;
    private List<TransItens> transItensList;

    public TransItens(long id)
    {
        transItensId = IDControl.getInstance().getItemNextId();
        transItensTrans = id;
        transItensList = new ArrayList<TransItens>();
    }

    public long getTransItensId() {
        return transItensId;
    }

    public void setTransItensId(long transItensId) {
        this.transItensId = transItensId;
    }

    public long getTransItensTrans() {
        return transItensTrans;
    }

    public void setTransItensTrans(long transItensTrans) {
        this.transItensTrans = transItensTrans;
    }

    public List<TransItens> getTransItensList() {
        return transItensList;
    }

    public void setTransItensList(List<TransItens> transItensList) {
        this.transItensList = transItensList;
    }
    
}
