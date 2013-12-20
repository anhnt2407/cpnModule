package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

import java.util.List;

/**
 *
 * @author Davi
 */
public class ColorXML
{

    public static String convert(Color color)
    {
        String ColorTxt = new String();
        
        ColorTxt += "\n        <color id=\"ID"+color.getId()+"\">\n"
                + "          <id>"+color.getNameId()+"</id>\n";
        
        ColorTxt += color.isTimed() ? "          <timed/>\n" : "";
        
        ColorTxt += with( "unit" , color.getUnit() );
        ColorTxt += with( "bool" , color.getBool() );
        ColorTxt += with( "int" , color.getInteiro() );
        ColorTxt += with( "real" , color.getReal() );
        ColorTxt += with( "string" , color.getString() );
        
        ColorTxt += recordField( color.getRecord() );

        ColorTxt += listString( "declare" , color.getDeclare() );
        ColorTxt += listString( "enum" , color.getEnums() );
        ColorTxt += listString( "product" , color.getProduct() );
        ColorTxt += listString( "list" , color.getList() );
        ColorTxt += listString( "alias" , color.getAlias() );

        if( color.getIndex() != null )
        {
            ColorTxt += IndexXML.convert( color.getIndex() );
        }

        if( color.getUnion() != null )
        {
            ColorTxt += UnionXML.convert( color.getUnion() );
        }

        if( color.getSubset() != null )
        {
            ColorTxt += SubsetXML.convert( color.getSubset() );
        }
        
        if( color.getLayout() != null )
        {
            ColorTxt += "\n          <layout>";
            ColorTxt += color.getLayout();
            ColorTxt += "\n          </layout>\n";
        }
        
        ColorTxt += "\n        </color>";
              
        return ColorTxt;
    }

    private static String recordField( List<RecordField> list )
    {
        String txt = "";

        if( list == null
                ? false
                : !list.isEmpty() )
        {
            txt += "          <record>\n";

            for( RecordField field : list )
            {
                 txt += "            <recordfield>\n";
                 txt += "              <id>" + field.getId() + "</id>\n";
                 txt += "              <id>" + field.getType() + "</id>\n";
                 txt += "            </recordfield>\n";
            }

            txt += "          </record>\n";
        }

        return txt;
    }

    private static String listString( String name , List<String> list )
    {
        String txt = "";

        if( list == null
                ? false
                : !list.isEmpty() )
        {
            txt += "          <"+ name +">\n";

            for( String value : list )
            {
                 txt += "            <id>" + value + "</id>\n";
            }

            txt += "          </"+ name +">\n";
        }

        return txt;
    }

    private static String with( String element , With with )
    {
        if( with != null )
        {
            if( with.getListMl().isEmpty() )
            {
                return "          <"+ element +"/>\n";
            }
            else
            {
                return "          <"+ element +">\n"
                     + WithXML.convert( with )
                     + "          </"+ element +">\n";
            }
        }
        else
        {
            return "";
        }
    }
}
