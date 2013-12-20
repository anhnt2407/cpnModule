/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

import java.util.List;

/**
 *
 * @author Davi
 */
public class UnionXML {
    
    public static String convert(List<Union> unionList){
   
        String unionTxt = new String();
        
        unionTxt += "          <union>\n";
        
        
        for( Union union : unionList){
            
            unionTxt += UnionXML.UnionConvert(union);
                        
        }
        
               
        unionTxt += "          </union>\n";
        
             
        
                    
        return unionTxt;
        
    }
    
    
    private static String UnionConvert(Union union){
        
        String unionConvertTxt = new String();
        
        unionConvertTxt+="           <unionfield>\n";
        
        unionConvertTxt+="           <id>"+union.getId()+"</id>\n";
        
        if(!(union.getTypeId().isEmpty())){
            
            unionConvertTxt+="            <type>\n           <id>"+union.getTypeId()+"</id>\n            </type>\n";
            
        }
        
        
        unionConvertTxt+="           </unionfield>\n";
        
        return unionConvertTxt;
        
    }
    
}
