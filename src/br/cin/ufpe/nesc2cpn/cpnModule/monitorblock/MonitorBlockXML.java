package br.cin.ufpe.nesc2cpn.cpnModule.monitorblock;

import java.util.List;
import java.util.Map.Entry;

/**
 *
 * @author Davi
 */
public class MonitorBlockXML {

    public static String convert( MonitorBlock monitorblock )
    {
        if( monitorblock == null )
        {
            return "\n        <monitorblock name=\"Monitors\" />\n";
        }
        
        String monitorBlockTxt = new String();

        for ( Entry<String, List<Monitor>> entry : monitorblock.getMonitorblock().entrySet() )
        {
            monitorBlockTxt += "\n        <monitorblock name=\"" + entry.getKey() + "\">\n";

            if ( !monitorblock.getListMonitorBlock().isEmpty() )
            {
                for ( MonitorBlock monitorBlock2 : monitorblock.getListMonitorBlock() )
                {
                    monitorBlockTxt += "\n" + convert( monitorBlock2 );
                }
            }

            for ( Monitor monitor : entry.getValue() )
            {
                monitorBlockTxt += MonitorXML.convert( monitor );
            }

            monitorBlockTxt += "\n        </monitorblock>\n";
        }


        if( !monitorblock.getMonitor().isEmpty() )
        {
            monitorBlockTxt += "<monitorblock name=\"Monitors\">";

            for ( Monitor monitor : monitorblock.getMonitor() )
            {
                monitorBlockTxt += MonitorXML.convert( monitor );
            }

            monitorBlockTxt += "</monitorblock>";
        }


        return monitorBlockTxt;
    }

}
