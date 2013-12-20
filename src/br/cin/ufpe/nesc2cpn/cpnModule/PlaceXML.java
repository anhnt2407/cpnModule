package br.cin.ufpe.nesc2cpn.cpnModule;

/**
 *
 * @author avld
 */
public class PlaceXML {

    public static String convert(Place place)
    {
        String placeTxt = new String();
        placeTxt +="\n      <place id=\"ID"+ place.getId() +"\">\n";

        placeTxt += "        <posattr x=\""+ place.getPosattrX() +"\""
                                   +" y=\""+ place.getPosattrY() +"\"/>\n";

        placeTxt += "        <fillattr colour=\""+ place.getFillattrColor() +"\""
                                   + " pattern=\""+ place.getFillattrPattern() +"\""
                                   + " filled=\""+ place.isFillattrFilled() +"\"/>\n";

        placeTxt += "        <lineattr colour=\""+ place.getLineattrColor() +"\""
                                   + " thick=\""+ place.getLineattrThick() +"\""
                                   + " type=\""+ place.getLineattrType() +"\"/>\n";

        placeTxt += "        <textattr colour=\""+ place.getTextattrColour() +"\""
                                   + " bold=\""+ place.isTextattrBold() +"\"/>\n";

        placeTxt += "        <text>"+ place.getText() +"</text>\n";

        placeTxt += "        <ellipse w=\""+ place.getEllipseWidth() +"\""
                                   +" h=\""+ place.getEllipseHeight() +"\"/>\n";

        placeTxt += "        <token x=\""+ place.getTokenX() +"\""
                                 +" y=\""+ place.getTokenY() +"\"/>\n";

        placeTxt += "        <marking x=\""+place.getMarkingX()+"\"\n"
                                + "                 y=\""+place.getMarkingY()+"\"\n"
                                + "                 hidden=\""+ place.isMarkingHidden()+"\">\n";
        
        placeTxt += "          <snap snap_id=\""+place.getSnapId()+ "\"\n"
                                + "                anchor.horizontal=\""+ place.getSnapHorizontal()+"\"\n"
                                + "                anchor.vertical=\""+place.getSnapVertical()+"\"/>\n";
        
        placeTxt +="        </marking>\n";
        placeTxt += CPNItemXML.convert("type", place.getType() );

        placeTxt += CPNItemXML.convert("initmark", place.getInitmark() );

        if( place.getPortType() != null )
        {
            placeTxt += getPort( place.getPortType() );
        }

        placeTxt += "      </place>\n";

        return placeTxt;
    }


    private static String getPort(CPNItem port)
    {
        String type = port.getText();
        String extra = " type=\""+ type +"\"";
        port.setText( null );

        String portTxt = CPNItemXML.convert("port" , port , extra );

        port.setText( type );

        return portTxt;
    }

}
