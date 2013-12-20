/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class IndexXML {
    
    public static String convert(Index index){
        String indexTxt = new String();
        indexTxt += "          <index>\n";
        indexTxt += MlXML.convert(index.getMl1());
        
        indexTxt += MlXML.convert(index.getMl2());
        
        indexTxt += "          <id>"+index.getId()+"</id>\n";
        
        indexTxt += "          </index>\n";
        
        
        
                    
        return indexTxt;
        
    }
    
}
