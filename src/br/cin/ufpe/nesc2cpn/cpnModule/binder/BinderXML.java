/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.binder;

/**
 *
 * @author Davi
 */
public class BinderXML
{

    public static String convert(Binder binder)
    {

        if( binder == null )
        {
            return "\n    <binders/>\n";
        }

        String pageTxt = new String();
        pageTxt += "\n    <binders>";
        pageTxt += "\n      <cpnbinder id=\"ID"+binder.getCpnbinderId()+"\""
                  +"\n                 x=\""+ binder.getCpnbinderX()
                  +"\"\n                 y=\""+ binder.getCpnbinderY()
                  +"\"\n                 width=\""+ binder.getCpnbinderWidth()
                  +"\"\n                 height=\"" + binder.getCpnbinderHight()
                  + "\">\n        <sheets>\n" ;

        for( Cpnsheet cpnsheet : binder.getSheet() )
        {
            pageTxt += CpnsheetXML.convert( cpnsheet );
        }

        pageTxt += "\n        </sheets>\n";

        pageTxt += "        <zorder>\n";

        for( Integer value : binder.getZorderPosition() )
        {
            pageTxt += "          <position value=\""+value+"\"/>\n";
        }

        pageTxt += "\n        </zorder>\n";
        pageTxt += "      </cpnbinder>\n";
        pageTxt += "    </binders>\n";

        return pageTxt;
    }

}
