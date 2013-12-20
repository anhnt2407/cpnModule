/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class WithXML
{
    
    public static String convert(With with)
    {
        String withTxt = new String();
        withTxt += "\n        <with>\n";
        
        withTxt += MlXML.convert( with.getMl() );
                
        for( Ml ml : with.getListMl() )
        {
            withTxt += MlXML.convert( ml );
        }
        
        if( !"".equals( with.getId1() ) )
        {
            withTxt += "<id>" + with.getId1() + "</id>\n";
        }
        
        if( !"".equals( with.getId2() ) )
        {
            withTxt += "<id>" + with.getId2() + "</id>\n";
        }
        
        withTxt += "\n        </with>\n";
                    
        return withTxt;
    }
    
}
