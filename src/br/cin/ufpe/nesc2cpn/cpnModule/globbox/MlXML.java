/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class MlXML {
    
    public static String convert(Ml ml)
    {
        String mlTxt = new String();
        
        mlTxt += "\n        <ml";
        if( ml.getId() != 0 )
        {
            mlTxt += " id=\"ID"+ml.getId()+"\"";
        }
            
        
        mlTxt += ">";
        
        for( String pcData : ml.getPcData() )
        {
            //pageTxt += PlaceXML.convert( place );
            mlTxt +="\n"+pcData ;
        }
        
        for( String layout : ml.getlistLayout() )
        {
            //pageTxt += PlaceXML.convert( place );
            layout = layout.replace( "<" , "&lt;" );

            mlTxt += layout + "\n";
            mlTxt +="          <layout>" + layout + "</layout>\n";
        }
        
        mlTxt += "\n        </ml>\n";
                    
        return mlTxt;
    }
    
}
