package br.cin.ufpe.nesc2cpn.cpnModule.monitorblock;

import br.cin.ufpe.nesc2cpn.cpnModule.globbox.Ml;
import br.cin.ufpe.nesc2cpn.cpnModule.globbox.MlXML;
import java.util.Map.Entry;

/**
 *
 * @author Davi
 */
public class MonitorXML
{
    
     public static String convert(Monitor monitor)
     {
        String monitorTxt = new String();
        monitorTxt += "\n          <monitor id=\"ID" + monitor.getId() +"\"\n"
                            +"                   name=\""+ monitor.getName()+"\"\n"
                            +"                   type=\""+ monitor.getType()+"\"\n"
                            +"                   typedescription=\""+ monitor.getTypeDescription()+"\"\n"
                            +"                   disabled=\""+ monitor.isDisable()+"\">\n";
        
        for ( Entry<Long,Long> entry : monitor.getNode().entrySet() )
        {
            monitorTxt += "            <node idref=\"ID" + entry.getKey()+ "\"\n"
                                +"                  pageinstanceidref=\"ID"+entry.getValue()+"\"/>\n";
        }
        
        for ( Ml function : monitor.getDeclaration() )
        {
            monitorTxt += "\n            <declaration name=\"Predicate\">\n"
                    + MlXML.convert( function )
                    +"            </declaration>\n";
        }
        
        for ( Entry<String,Object> entry : monitor.getOption().entrySet() )
        {
            monitorTxt += "            <option name=\"" + entry.getKey()+ "\"\n"
                       +"                    value=\""+entry.getValue()+"\"/>\n";
        }
        
        monitorTxt += "          </monitor>";
         
        return monitorTxt;
    }
    
}
