/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class UseXML {
    
    public static String convert(Use use){
        String useTxt = new String();
        
        useTxt += "\n        <use id=\"" + use.getId()+ "\">\n";
                
          
        
        useTxt +="          <ml>"+use.getNameId()+"</ml>\n";
       
        
        useTxt +="          <layout>"+use.getLayout()+"</layout>\n";
        
        useTxt +="        </use>\n";
      
        return useTxt;
        
    }
    
    
}
