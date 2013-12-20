package br.cin.ufpe.nesc2cpn.cpnModule;

/**
 *
 * @author avld
 */
public class CPNItemXML {

    public static String convert(String type, CPNItem item)
    {
        return convert( type , item , "" );
    }

    public static String convert(String type, CPNItem item, String extra)
    {
        return convert( type , item , extra , true );
    }
    
    public static String convert(String type, CPNItem item, String extra, boolean needText)
    {
        if( item == null )
        {
            item = new CPNItem();
        }

        if( extra == null )
        {
            extra = "";
        }

        String txt = new String();
        txt += "        <"+type+" id=\"ID"+ item.getId() +"\""+ extra +">\n";

        txt += "          <posattr x=\""+ item.getPosattrX() +"\""
                                +" y=\""+ item.getPosattrY() +"\"/>\n";

        txt += "          <fillattr colour=\""+ item.getFillattrColor() +"\""
                               + " pattern=\""+ item.getFillattrPattern() +"\""
                                + " filled=\""+ item.isFillattrFilled() +"\"/>\n";

        txt += "          <lineattr colour=\""+ item.getLineattrColor() +"\""
                                 + " thick=\""+ item.getLineattrThick() +"\""
                                  + " type=\""+ item.getLineattrType() +"\"/>\n";

        txt += "          <textattr colour=\""+ item.getTextattrColour() +"\""
                                  + " bold=\""+ item.isTextattrBold() +"\"/>\n";

        if( needText )
        {
            if( item.getText() == null ? true : item.getText().isEmpty() )
            {
                txt += "          <text tool=\"CPN Tools\" version=\"2.3.4\"/>\n";
            }
            else
            {
                txt += "          <text tool=\"CPN Tools\" version=\"2.3.4\">"
                                         + EscapeChars.forXML( item.getText() ) +"</text>\n";
            }
        }

        txt += "        </"+ type +">\n";

        return txt;
    }

}
