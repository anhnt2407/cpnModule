/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule;

/**
 *
 * @author Davi
 */
public class ArcXML {
    
    public static String convert(Arc arc)
    {

        String arcTxt = new String();


        arcTxt += "\n      <arc id=\"ID" + arc.getId()
                + "\" orientation=\"" + arc.getOrientation()
                + "\" order=\"" + arc.getOrder() + "\">\n";


        arcTxt += "        <posattr x=\"" + arc.getPosattrX() + "\""
                + " y=\"" + arc.getPosattrY() + "\"/>\n";

        arcTxt += "        <fillattr colour=\"" + arc.getFillattrColor() + "\""
                + " pattern=\"" + arc.getFillattrPattern() + "\""
                + " filled=\"" + arc.isFillattrFilled() + "\"/>\n";


        arcTxt += "        <lineattr colour=\"" + arc.getLineattrColor() + "\""
                + " thick=\"" + arc.getLineattrThick() + "\""
                + " type=\"" + arc.getLineattrType() + "\"/>\n";

        arcTxt += "        <textattr colour=\"" + arc.getTextattrColour() + "\""
                + " bold=\"" + arc.isTextattrBold() + "\"/>\n";

        arcTxt += "        <transend idref=\"ID" + arc.getTransendIdref() + "\"/>\n";
        arcTxt += "        <placeend idref=\"ID" + arc.getPlaceendIdref() + "\"/>\n";
        
        if( arc.getBendpointList() != null )
        {
            for(int i = 0; i < arc.getBendpointList().size(); i++)
            {
                CPNItem endpoint = arc.getBendpointList().get( i );

                arcTxt += CPNItemXML.convert("bendpoint", endpoint , " serial=\""+(i+1)+"\"");
            }
        }

        arcTxt += CPNItemXML.convert( "annot" , arc.getAnnot() );
        arcTxt += "      </arc>\n";

        return arcTxt;
    }

}
