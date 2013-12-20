package br.cin.ufpe.nesc2cpn.cpnModule.instances;

/**
 *
 * @author Davi
 */
public class TransItensXML
{
    
    public static String convert(TransItens transItens)
    {
        String transTxt = new String();
        
        transTxt += "\n        <instance id=\"ID"+ transItens.getTransItensId() +"\" "
                                   + "trans=\"ID" + transItens.getTransItensTrans() + "\"";
        
        if( transItens.getTransItensList().isEmpty() )
        {
            transTxt += "/";
        }
        
        transTxt += ">\n";
        
        for( TransItens itens : transItens.getTransItensList() )
        {
            transTxt += convert( itens );
        }
        
        if( !transItens.getTransItensList().isEmpty() )
        {
            transTxt += "</instance>\n";
        }
        
        return transTxt;
    }

}