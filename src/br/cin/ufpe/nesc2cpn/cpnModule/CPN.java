package br.cin.ufpe.nesc2cpn.cpnModule;

import br.cin.ufpe.nesc2cpn.cpnModule.IndexNode.IndexNode;
import br.cin.ufpe.nesc2cpn.cpnModule.binder.Binder;
//import br.cin.ufpe.nesc2cpn.cpnModule.globbox.Block;
import br.cin.ufpe.nesc2cpn.cpnModule.globbox.BlockItem;
import br.cin.ufpe.nesc2cpn.cpnModule.group.Group;
import br.cin.ufpe.nesc2cpn.cpnModule.instances.InstanceItens;
import br.cin.ufpe.nesc2cpn.cpnModule.monitorblock.MonitorBlock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author avld
 */
public class CPN
{
    private List<BlockItem> globbox;

    private List<Page> page;

    private List<Group> group;
    private List<InstanceItens> instances;

    private Map<String,Object> options;

    private Binder binders;
    private MonitorBlock monitors;
    private IndexNode indexNode;

    public CPN()
    {
        globbox = new ArrayList<BlockItem>();
        page = new ArrayList<Page>();
        group = new ArrayList<Group>();
        //instances = new ArrayList<Instances>();
        options = new HashMap<String, Object>();
        monitors = new MonitorBlock();
        instances = new ArrayList<InstanceItens>();
        
        setDefaultOptions();
    }

    private void setDefaultOptions()
    {
        options.put("realtimestamp",(Boolean) false );
        options.put("fair_be",(Boolean) false );
        options.put("global_fairness",(Boolean) true );
        options.put("outputdirectory" , "<same as model>" );
        options.put("repavg",(Boolean) true );
        options.put("repciavg",(Boolean) true );
        options.put("repcount",(Boolean) false );
        options.put("repfirstval",(Boolean) false );
        options.put("replastval",(Boolean) false );
        options.put("repmax",(Boolean) true );
        options.put("repmin",(Boolean) true );
        options.put("repssquare",(Boolean) false );
        options.put("repssqdev",(Boolean) false );
        options.put("repstddev",(Boolean) true );
        options.put("repsum",(Boolean) false );
        options.put("repvariance",(Boolean) false );
        options.put("avg",(Boolean) true );
        options.put("ciavg",(Boolean) false );
        options.put("count",(Boolean) true );
        options.put("firstval",(Boolean) false );
        options.put("lastval",(Boolean) false );
        options.put("max",(Boolean) true );
        options.put("min",(Boolean) true );
        options.put("ssquare",(Boolean) false );
        options.put("ssqdev",(Boolean) false );
        options.put("stddev",(Boolean) false );
        options.put("sum",(Boolean) false );
        options.put("variance",(Boolean) false );
        options.put("firstupdate",(Boolean) false );
        options.put("interval",(Boolean) false );
        options.put("lastupdate",(Boolean) false );
        options.put("untimedavg",(Boolean) true );
        options.put("untimedciavg",(Boolean) false );
        options.put("untimedcount",(Boolean) true );
        options.put("untimedfirstval",(Boolean) false );
        options.put("untimedlastval",(Boolean) false );
        options.put("untimedmax",(Boolean) true );
        options.put("untimedmin",(Boolean) true );
        options.put("untimedssquare",(Boolean) false );
        options.put("untimedssqdev",(Boolean) false );
        options.put("untimedstddev",(Boolean) false );
        options.put("untimedsum",(Boolean) true );
        options.put("untimedvariance",(Boolean) false );
        
    }

    public Binder getBinders() {
        return binders;
    }

    public void setBinders(Binder binders) {
        this.binders = binders;
    }

    public List<BlockItem> getGlobbox() {
        return globbox;
    }

    public void setGlobbox(List<BlockItem> globbox) {
        this.globbox = globbox;
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public IndexNode getIndexNode() {
        return indexNode;
    }

    public void setIndexNode(IndexNode indexNode) {
        this.indexNode = indexNode;
    }

    public List<InstanceItens> getInstances() {
        return instances;
    }

    public void setInstances(List<InstanceItens> instances) {
        this.instances = instances;
    }

    public MonitorBlock getMonitors() {
        return monitors;
    }

    public void setMonitors(MonitorBlock monitors) {
        this.monitors = monitors;
    }

    public Map<String, Object> getOptions() {
        return options;
    }

    public void setOptions(Map<String, Object> options) {
        this.options = options;
    }

    public List<Page> getPage() {
        return page;
    }

    public void setPage(List<Page> page) {
        this.page = page;
    }

}
