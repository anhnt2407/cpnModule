/*
 * <!ELEMENT monitorblock (monitor)*>
<!ATTLIST monitorblock name     CDATA       #REQUIRED>


<!ELEMENT monitor   ((node*), (declaration*), (option*))>
<!ATTLIST monitor   id          ID          #REQUIRED
                    name        CDATA       #REQUIRED
		    type        %number;    #REQUIRED
		    typedescription CDATA   #REQUIRED
		    disabled    %boolean;   #REQUIRED>


<!ELEMENT node      EMPTY>

<!ATTLIST node      idref       CDATA       #REQUIRED
                    pageinstanceidref CDATA #REQUIRED>

<!ELEMENT declaration (ml)>
<!ATTLIST declaration name      CDATA       #REQUIRED>


<!ELEMENT option    (value?)>
<!ATTLIST option    name        CDATA       #REQUIRED
                    value       %boolean;   #IMPLIED>

<!ELEMENT ml        (#PCDATA | layout)*>
<!ATTLIST ml        id          ID          #IMPLIED>


<!ELEMENT value     (text)>
<!ELEMENT layout    (#PCDATA)>

<!ELEMENT text      (#PCDATA)>
<!ATTLIST text      tool CDATA "CPN Tools"
                    version CDATA #IMPLIED>
 */
package br.cin.ufpe.nesc2cpn.cpnModule.monitorblock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Davi
 */
public class MonitorBlock {
    private Map<String,List<Monitor>> monitorblock;
    private List<Monitor> monitor;
    private List<MonitorBlock> listMonitorBlock;

    
    public MonitorBlock() 
    {
        monitorblock     = new HashMap<String, List<Monitor>>();
        monitor          = new ArrayList<Monitor>();
        listMonitorBlock = new ArrayList<MonitorBlock>();

    }
    
    public MonitorBlock( MonitorBlock monitorBlockList )
    {
        monitorblock     = new HashMap<String,List<Monitor>>();
        monitor          = new ArrayList<Monitor>();
        
        listMonitorBlock = new ArrayList<MonitorBlock>();
        listMonitorBlock.add(monitorBlockList);
    } 
    
    
    public MonitorBlock(String monitorBlockName, List<Monitor> listMonitor)
    {
        monitorblock = new HashMap<String,List<Monitor>>();
        monitor = new ArrayList<Monitor>();
        //monitor=listMonitor;
        
        monitorblock.put(monitorBlockName, listMonitor);
        //monitorblock.put(monitorBlockName, listMonitor);
        
        listMonitorBlock = new ArrayList<MonitorBlock>();
        //listMonitorBlock.add(monitorBlockList);
    } 
    
    public Map<String, List<Monitor>> getMonitorblock() {
        return monitorblock;
    }

    public void setMonitorblock(Map<String, List<Monitor>> monitorblock) {
        this.monitorblock = monitorblock;
    }

    public List<MonitorBlock> getListMonitorBlock() {
        return listMonitorBlock;
    }

    public void setListMonitorBlock(List<MonitorBlock> listMonitorBlock) {
        this.listMonitorBlock = listMonitorBlock;
    }
    

    public List<Monitor> getMonitor() {
        return monitor;
    }

    public void setMonitor(List<Monitor> monitor) {
        this.monitor = monitor;
    }
    
}
