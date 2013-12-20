package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class BlockXML
{
    
    public static String convert( Block block )
    {
        String blockConvertTxt = "\n";
        blockConvertTxt += "      <block id=\"ID"+ block.getId() +"\">\n";
        blockConvertTxt += "        <id>"+block.getNameId()+"</id>\n";

        for( BlockItem item : block.getItemList() )
        {
            blockConvertTxt += convert( item );
        }

        blockConvertTxt += "\n      </block>";
        
        return blockConvertTxt;
    }

    private static String convert(BlockItem item)
    {
        if( item instanceof Block )
        {
            return BlockXML.convert( (Block) item );
        }
        else if(item instanceof Color)
        {
            return ColorXML.convert( (Color) item );
        }
        else if(item instanceof Var)
        {
            return VarXML.convert( (Var) item );
        }
        else if(item instanceof GlobRef)
        {
            return GlobRefXML.convert( (GlobRef) item );
        }
        else if(item instanceof Ml)
        {
            return MlXML.convert( (Ml) item );
        }
        else if(item instanceof GlobRef)
        {
            return UseXML.convert( (Use) item );
        }
        else
        {
            return "";
        }
    }
}
