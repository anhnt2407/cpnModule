/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.binder;

/**
 *
 * @author Davi
 */
public class CpnsheetXML {
    
    public static String convert(Cpnsheet cpnsheet){
        String pageTxt = new String();


        if (cpnsheet.getCpnsheetInstance() != 0) {

            pageTxt += "\n          <cpnsheet id=\"ID" + cpnsheet.getCpnsheetId()
                    + "\"\n                    panx=\"" + cpnsheet.getCpnsheetPanx()
                    + "\"\n                    pany=\"" + cpnsheet.getCpnsheetPany()
                    + "\"\n                    zoom=\"" + cpnsheet.getCpnsheetZoom();

            pageTxt += "\"\n                    instance=\"ID" + cpnsheet.getCpnsheetInstance();

            pageTxt += "\">\n            <zorder>\n";
            

        } else if (cpnsheet.getCpnsheetDecl() != 0) {
            pageTxt += "\n          <textsheet id=\"ID" + cpnsheet.getCpnsheetId()
                    + "\"\n                    panx=\"" + cpnsheet.getCpnsheetPanx()
                    + "\"\n                    pany=\"" + cpnsheet.getCpnsheetPany()
                    + "\"\n                    zoom=\"" + cpnsheet.getCpnsheetZoom();
            pageTxt +="\"\n                    decl=\"ID" + cpnsheet.getCpnsheetDecl();

            pageTxt += "\">\n            <zorder>\n";
        }



        for( Integer value : cpnsheet.getZorderPosition() ){
            
            pageTxt += "\n              <position value=\""+value+"\"/>";
        }
        
        if (cpnsheet.getCpnsheetInstance() != 0) {
            pageTxt += "\n            </zorder>\n          </cpnsheet>";
            
        }else if (cpnsheet.getCpnsheetDecl() != 0) {
            pageTxt += "\n            </zorder>\n          </textsheet>";
        }
        
        
        
        
        return pageTxt;
        
        
    }
    
}
