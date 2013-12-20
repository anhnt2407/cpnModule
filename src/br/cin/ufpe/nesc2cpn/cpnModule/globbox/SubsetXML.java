/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class SubsetXML {
    
    public static String convert(Subset subset){
        String subsetTxt = new String();
        
        subsetTxt+="          <subset>\n";
        
        if(!"".equals(subset.getId())){
            
            subsetTxt+="           <id>"+subset.getId()+"</id>\n";
            
        }
        
        
        if(subset.getWith()!=null){
            
            subsetTxt+= WithXML.convert(subset.getWith());
            
        }
        
        if(subset.getBy()!=null){
            
            subsetTxt+="           <by>"+MlXML.convert(subset.getBy())+"</by>\n";
            
        }
        
        
        subsetTxt+="          </subset>\n";
        
        
        
        
        
                    
        return subsetTxt;
        
    }
    
}
