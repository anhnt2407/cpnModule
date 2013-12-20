package br.cin.ufpe.nesc2cpn.cpnModule.IndexNode;

/**
 *
 * @author Davi
 */
public class IndexNodeXML {

    public static String convert(IndexNode indexNodeList)
    {
        if( indexNodeList == null )
        {
            return "";
        }
        
        return convert( indexNodeList , "  " );
    }

    public static String convert(IndexNode node , String startStr)
    {
        String IndexNodeTxt = new String();
        IndexNodeTxt += startStr;
        IndexNodeTxt += "  <IndexNode expanded=\""+ node.isIndexNodeExpanded() +"\"";

        if( node.getIndexNode().isEmpty() )
        {
            IndexNodeTxt += "/";
        }

        IndexNodeTxt += ">\n";

        for( IndexNode index : node.getIndexNode() )
        {
            IndexNodeTxt += convert( index , startStr + "  " );
        }

        if( !node.getIndexNode().isEmpty() )
        {
            IndexNodeTxt += startStr + "  </IndexNode>\n";
        }

        return IndexNodeTxt;
    }

}
