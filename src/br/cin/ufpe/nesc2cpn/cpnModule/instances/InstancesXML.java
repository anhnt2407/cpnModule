/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.instances;

import java.util.List;

/**
 *
 * @author Davi
 */
public class InstancesXML {
    
    public static String convert( List<InstanceItens> instances )
    {
        if( instances == null )
        {
            return "";
        }
        
        String instancesTxt = new String();
        instancesTxt += "\n    <instances>\n";
        
        for( InstanceItens instanceItens : instances )
        {
            instancesTxt += InstanceItensXML.convert(instanceItens);
        }
          
        instancesTxt += "\n    </instances>\n";
        
        return instancesTxt;

    }
    
}
