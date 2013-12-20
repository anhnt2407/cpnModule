package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.globbox.Color;
import br.cin.ufpe.nesc2cpn.cpnModule.globbox.RecordField;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avld
 */
public class ColorLoad extends BlockItemLoad
{

    public ColorLoad( Node node )
    {
        super( node );
    }

    public Color getColor()
    {
        Color color = new Color();
        color.setId( getID() );

        NodeList list = node.getChildNodes();
        for( int i = 0 ; i < list.getLength() ; i++ )
        {
            Node children = list.item( i );

            if( "layout".equalsIgnoreCase( children.getNodeName() ) )
            {
                color.setLayout( getText( children ) );
            }
            else if( "id".equalsIgnoreCase( children.getNodeName() ) )
            {
                color.getNameIdList().add( getText( children ) );
            }
            else if( "timed".equalsIgnoreCase( children.getNodeName() ) )
            {
                color.setTimed( true );
            }
            else if( "unit".equalsIgnoreCase( children.getNodeName() ) )
            {
                WithLoad load = new WithLoad( node );
                color.setUnit( load.getWith() );
            }
            else if( "bool".equalsIgnoreCase( children.getNodeName() ) )
            {
                WithLoad load = new WithLoad( node );
                color.setBool( load.getWith() );
            }
            else if( "int".equalsIgnoreCase( children.getNodeName() ) )
            {
                WithLoad load = new WithLoad( node );
                color.setInteiro( load.getWith() );
            }
            else if( "real".equalsIgnoreCase( children.getNodeName() ) )
            {
                WithLoad load = new WithLoad( node );
                color.setReal( load.getWith() );
            }
            else if( "string".equalsIgnoreCase( children.getNodeName() ) )
            {
                WithLoad load = new WithLoad( node );
                color.setString( load.getWith() );
            }
            else if( "declare".equalsIgnoreCase( children.getNodeName() ) )
            {
                color.setDeclare( getListId( children ) );
            }
            else if( "enum".equalsIgnoreCase( children.getNodeName() ) )
            {
                color.setEnums( getListId( children ) );
            }
            else if( "alias".equalsIgnoreCase( children.getNodeName() ) )
            {
                color.setAlias( getListId( children ) );
            }
            else if( "product".equalsIgnoreCase( children.getNodeName() ) )
            {
                color.setProduct( getListId( children ) );
            }
            else if( "list".equalsIgnoreCase( children.getNodeName() ) )
            {
                color.setList( getListId( children ) );
            }
            else if( "record".equalsIgnoreCase( children.getNodeName() ) )
            {
                color.setRecord( getRecordFieldList( children ) );
            }
            else if( "subset".equalsIgnoreCase( children.getNodeName() ) )
            {
                //TODO: salvar subset
            }
            else if( "index".equalsIgnoreCase( children.getNodeName() ) )
            {
                //TODO: salvar index
            }
        }

        return color;
    }

    private List<RecordField> getRecordFieldList(Node node)
    {
        List<RecordField> recordList = new ArrayList<RecordField>();

        NodeList list = node.getChildNodes();
        for( int i = 0 ; i < list.getLength() ; i++ )
        {
            Node children = list.item( i );
            
            if( "recordfield".equalsIgnoreCase( children.getNodeName() ) )
            {
                recordList.add( getRecordField( children ) );
            }
        }

        return recordList;
    }

    private RecordField getRecordField(Node node)
    {
        String name = "";
        String type = "";
        boolean first = true;

        NodeList list = node.getChildNodes();
        for( int i = 0 ; i < list.getLength() ; i++ )
        {
            Node children = list.item( i );

            if( "id".equalsIgnoreCase( children.getNodeName() ) )
            {
                if( first )
                {
                    name = getText( children );
                    first = false;
                }
                else
                {
                    type = getText( children );
                    break;
                }
            }
        }

        RecordField field = new RecordField();
        field.setId( name );
        field.setType( type );

        return field;
    }
}
