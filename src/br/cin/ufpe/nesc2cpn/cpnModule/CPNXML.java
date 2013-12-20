package br.cin.ufpe.nesc2cpn.cpnModule;

import br.cin.ufpe.nesc2cpn.cpnModule.IndexNode.IndexNodeXML;
import br.cin.ufpe.nesc2cpn.cpnModule.binder.BinderXML;
//import br.cin.ufpe.nesc2cpn.cpnModule.globbox.BlockXML;
import br.cin.ufpe.nesc2cpn.cpnModule.globbox.GlobBoxXML;
import br.cin.ufpe.nesc2cpn.cpnModule.group.Group;
import br.cin.ufpe.nesc2cpn.cpnModule.group.GroupXML;
import br.cin.ufpe.nesc2cpn.cpnModule.instances.InstancesXML;
import br.cin.ufpe.nesc2cpn.cpnModule.monitorblock.MonitorBlockXML;
import java.util.Map.Entry;

/**
 *
 * @author avld
 */
public class CPNXML {

    public static String convertTo(CPN cpn) throws Exception {
        //CPNXML cpnXML = new CPNXML();
        String cpnTxt = new String();
        
        cpnTxt+="<workspaceElements>\n"
              + "  <generator tool=\"CPN Tools\"\n"
              + "             version=\"2.3.12\"\n"
              + "             format=\"6\"/>\n";
        
        cpnTxt+= "  <cpnet>";
        cpnTxt+= GlobBoxXML.convert( cpn.getGlobbox() );
        
        for( Page page : cpn.getPage() )
        {
            cpnTxt+= PageXML.convert( page );
        }
        
        for ( Group group : cpn.getGroup() )
        {
            cpnTxt += GroupXML.convert( group );
        }

        cpnTxt += InstancesXML.convert( cpn.getInstances() );

        cpnTxt += "\n    <options>\n";
        
        for ( Entry<String, Object> entry : cpn.getOptions().entrySet() )
        {
            cpnTxt += optionToString( entry );
        }
        cpnTxt += "\n    </options>\n";

        cpnTxt+= BinderXML.convert(cpn.getBinders());
        cpnTxt+= MonitorBlockXML.convert(cpn.getMonitors());
        cpnTxt+= IndexNodeXML.convert(cpn.getIndexNode());

        cpnTxt+= "  </cpnet>\n</workspaceElements>";
        
        
        return cpnTxt;
    }


    private static String optionToString(Entry<String,Object> entry){
        String txt = "";
        
        txt += "              <option name=\""+ entry.getKey() +"\">\n";
        txt += "                <value>\n";

        if( entry.getValue() instanceof Boolean )
        {
            txt += "                  <boolean>"+entry.getValue()+"</boolean>\n";
        }
        else
        {
            txt += "                  <text>"+ sub( entry.getValue().toString() ) +"</text>\n";
        }

        txt += "                </value>\n";
        txt += "              </option>\n";
        
        return txt;
    }

    private static String sub(String txt){
        txt = txt.replaceAll("<", "&lt;");
        txt = txt.replaceAll(">", "&gt;");

        return txt;
    }
}
