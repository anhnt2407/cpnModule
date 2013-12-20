/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.instances;

/**
 *
 * @author Davi
 */
public class InstanceItensXML {
    
    public static String convert(InstanceItens instanceItens){
        String instanceTxt = new String();
        instanceTxt += "\n      <instance id=\"ID" + instanceItens.getInstanceId()
                            + "\"\n                page=\"ID"+instanceItens.getInstancePage()+"\"";
        
        if( instanceItens.getInstanceTrans() == null ? true : instanceItens.getInstanceTrans().isEmpty() )
            instanceTxt += " />";
        else
        {
             instanceTxt += ">";

            for( TransItens transItens : instanceItens.getInstanceTrans() )
            {
                instanceTxt += TransItensXML.convert( transItens );
            }
            
            instanceTxt += "\n      </instance>\n";
        }  
        
        
        return instanceTxt;

    }
    
}
