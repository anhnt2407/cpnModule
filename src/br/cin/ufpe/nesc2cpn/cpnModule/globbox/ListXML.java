/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class ListXML {
    
    public static String convert(Lister list)
    {
        String listTxt = new String();        
        listTxt += "          <list>\n";
        
        if ( list.getWith() != null )
        {
            listTxt += WithXML.convert( list.getWith() );
        }
       
        listTxt += "            <id>"+list.getId()+"</id>\n";
        listTxt += "          </list>\n";
                    
        return listTxt;
        
    }
    
}
