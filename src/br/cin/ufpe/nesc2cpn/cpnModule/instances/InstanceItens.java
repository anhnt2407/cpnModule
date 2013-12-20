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
public class InstanceItens
{
    private long instanceId;
    private long instancePage;
    private List<TransItens> instanceTrans;
    
    public InstanceItens()
    {
       instanceId = IDControl.getInstance().getItemNextId();
       instanceTrans = new ArrayList<TransItens>();
    }

    public InstanceItens(long page)
    {
       instanceId = IDControl.getInstance().getItemNextId();
       instancePage = page;
       
       instanceTrans = new ArrayList<TransItens>();
    }

    public long getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(long instanceId) {
        this.instanceId = instanceId;
    }

    public long getInstancePage() {
        return instancePage;
    }

    public void setInstancePage(long instancePage) {
        this.instancePage = instancePage;
    }

    public List<TransItens> getInstanceTrans() {
        return instanceTrans;
    }

    public void setInstanceTrans(List<TransItens> instanceTrans) {
        this.instanceTrans = instanceTrans;
    }

}
