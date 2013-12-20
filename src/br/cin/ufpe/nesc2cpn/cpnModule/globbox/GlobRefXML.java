/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class GlobRefXML {
    
    public static String convert(GlobRef globRef)
    {
        String globRefTxt = new String();
        
        globRefTxt += "\n        <globref id=\"ID" + globRef.getId() + "\">\n";
                
        if( !( "".equals( globRef.getNameId() ) ) )
        {
            globRefTxt +="          <id>" + globRef.getNameId() + "</id>\n";
        }  
        
        if( !("".equals(globRef.getMl() ) ) )
        {
            globRefTxt +="          <ml>" + globRef.getMl() + "</ml>\n";
        } 
        
        if( !( "".equals(globRef.getLayout() ) ) )
        {
            globRefTxt +="          <layout>" + globRef.getLayout() + "</layout>\n";
        }
        
        globRefTxt +="        </globref>\n";
      
        return globRefTxt;
        
    }
    
    
}
