/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

import java.util.List;

/**
 *
 * @author Davi
 */
public class GlobBoxXML
{

    public static String convert( List<BlockItem> globBox )
    {
        String globBoxTxt = new String();

        globBoxTxt += "\n    <globbox>\n";

        for (BlockItem item : globBox )
        {
            globBoxTxt += convert( item );
        }

        globBoxTxt += "\n    </globbox>\n";

        return globBoxTxt;
    }

    private static String convert(BlockItem objeto)
    {
        if(objeto instanceof Block)
        {
            return BlockXML.convert( (Block) objeto );
        }
        else if(objeto instanceof Color)
        {
            return ColorXML.convert( (Color) objeto );
        }
        else if(objeto instanceof Var)
        {
            return VarXML.convert((Var) objeto);
        }
        else if(objeto instanceof GlobRef)
        {
            return GlobRefXML.convert( (GlobRef) objeto );
        }
        else if(objeto instanceof Ml)
        {
            return MlXML.convert( (Ml) objeto );
        }
        else if(objeto instanceof Use)
        {
            return UseXML.convert( (Use) objeto );
        }
        else
        {
            return "";
        }
    }
}
