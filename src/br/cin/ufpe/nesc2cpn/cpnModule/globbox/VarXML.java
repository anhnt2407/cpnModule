
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class VarXML
{
    
    public static String convert(Var var)
    {
        String VarTxt = new String();
        VarTxt += "\n        <var id=\"ID" + var.getId() + "\">\n";
        
        VarTxt += "          <type>\n";
        for( String typeId : var.getTypeIdList() )
        {
            VarTxt += "            <id>"+ typeId +"</id>\n";
        }
        VarTxt += "          </type>\n";
        
        for( String nameId : var.getNameIdList() )
        {
            VarTxt +="\n        <id>" + nameId + "</id>" ;
        }
       
        if( !( var.getLayout() == null ) )
        {
            VarTxt +="\n          <layout>" + var.getLayout() + "</layout>";
        } 
       
        VarTxt+="\n        </var>";
        
        return VarTxt;
        
    }
    
}
