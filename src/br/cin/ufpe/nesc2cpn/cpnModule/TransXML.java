package br.cin.ufpe.nesc2cpn.cpnModule;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author Davi
 */
public class TransXML {
    public static String convert(Trans trans){
        String transTxt = new String();
        
        transTxt += "\n      <trans id=\"ID"+trans.getId()+ "\" explicit=\""
                                    + trans.isTransExplicit()+ "\">\n";
        
        transTxt += "        <posattr x=\""+trans.getPosattrX()+ "\""
                                    +" y=\""+ trans.getPosattrY()+"\"/>\n";
        
        transTxt += "        <fillattr colour=\"" + trans.getFillattrColor()+ "\""
                                    +" pattern=\"" + trans.getFillattrPattern()+"\""
                                    +" filled=\""+ trans.isFillattrFilled()+"\"/>\n";
        
        
        transTxt += "        <lineattr colour=\""+ trans.getLineattrColor() +"\""
                                    + " thick=\""+ trans.getLineattrThick() +"\""
                                    + " type=\""+ trans.getLineattrType() +"\"/>\n";

        transTxt += "        <textattr colour=\""+ trans.getTextattrColour() +"\""
                                    + " bold=\""+ trans.isTextattrBold() +"\"/>\n";

        transTxt += "        <text>"+ trans.getText() +"</text>\n";
        
        
        transTxt += "        <box w=\""+ trans.getBoxW()+"\""
                                    +" h=\""+ trans.getBoxH()+ "\"/>\n";
        
        if ( trans.getPortSock() == null 
                ? false 
                : !trans.getPortSock().isEmpty() )
        {
            transTxt += getSubst( trans );
        }
        
        transTxt += "        <binding x=\""+ trans.getBindingX() + "\""
                                    +" y=\""+ trans.getBindingY() + "\"/>\n";
         
        transTxt += CPNItemXML.convert("cond", trans.getCond() );
        transTxt += CPNItemXML.convert("time", trans.getTime() );
        transTxt += CPNItemXML.convert("code", trans.getCode() );
        transTxt += CPNItemXML.convert("channel", trans.getChannel() );
        transTxt += CPNItemXML.convert("priority", trans.getPriority() );
        
        transTxt += "      </trans>\n";
        
                
       
        return transTxt;   
    }

    private static String getSubst( Trans trans )
    {
        
        String substTxt = new String();

        substTxt += "        <subst subpage=\"ID" + trans.getPortsockId() + "\""
                    + " portsock=\"" + getPortsock( trans.getPortSock() ) + "\">\n";

        CPNItem subpage = trans.getSubpageinfo();
        String name = subpage.getText();

        subpage.setText( null );

        substTxt += CPNItemXML.convert("subpageinfo", trans.getSubpageinfo(), " name=\""+ name +"\"", true);

        substTxt += "        </subst>";

        return substTxt;
    }

    private static String getPortsock(Map<Long,List<Long>> portsock)
    {
        String portsockTxt = new String();

        for( Entry<Long,List<Long>> entry : portsock.entrySet() )
        {
            for(Long id2 : entry.getValue() )
            {
                portsockTxt += "(ID"+ id2 +",ID" + entry.getKey() + ")";
            }
        }

        return portsockTxt;
    }
}
