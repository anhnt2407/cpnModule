package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.CPNItem;
import org.w3c.dom.Node;

/**
 *
 * @author avld
 */
public class CpnItemLoad
{
    protected CPNItem cpnItem;
    protected Node node;

    public CpnItemLoad(Node node)
    {
        cpnItem = new CPNItem();
        this.node = node;
    }
    
    public CpnItemLoad(CPNItem cpnItem, Node node)
    {
        this.cpnItem = cpnItem;
        this.node = node;
    }

    public CPNItem getCpnItem()
    {
        cpnItem.setId( getID() );

        for( int i = 0; i < node.getAttributes().getLength(); i++ )
        {
            Node n = node.getAttributes().item( i );

            if( !"id".equals( n.getNodeName() ) )
            {
                foundExtraAttr( n );
            }
        }

        for( int i = 0; i < node.getChildNodes().getLength(); i++ )
        {
            Node n = node.getChildNodes().item( i );

            if( "posattr".equals( n.getNodeName() ) )
            {
                double[] values = getPos( n );
                
                cpnItem.setPosattrX( values[0] );
                cpnItem.setPosattrY( values[1] );
            }
            else if("fillattr".equals(n.getNodeName()))
            {
                String[] values = getFill( n );

                cpnItem.setFillattrColor( values[0] );
                cpnItem.setFillattrPattern( values[1] );
                cpnItem.setFillattrFilled( Boolean.parseBoolean( values[2] ) );
            }
            else if( "lineattr".equals( n.getNodeName() ) )
            {
                String[] values = getLine( n );

                cpnItem.setLineattrColor( values[0] );
                cpnItem.setLineattrThick( Integer.parseInt( values[1] ) );
                cpnItem.setLineattrType( values[2] );
            }
            else if( "textattr".equals( n.getNodeName() ) )
            {
                String[] values = getTextAttr( n );

                cpnItem.setTextattrColour( values[0] );
                cpnItem.setTextattrBold( Boolean.parseBoolean( values[1] ) );
                
            }
            else if( "text".equals( n.getNodeName() ) )
            {
                cpnItem.setText( getText( n ) );
            }
            else
            {
                foundExtraNode( n );
            }
        }

        return cpnItem;
    }

    // ------------------------------- //

    public void foundExtraAttr( Node node )
    {
        // do nothing
    }

    public void foundExtraNode( Node node )
    {
        // do nothing
    }

    // ------------------------------- //

    public int getID()
    {
        Node idNode = node.getAttributes().getNamedItem( "id" );
        String idStr = idNode.getNodeValue().substring( 2 );

        return Integer.parseInt( idStr );
    }

    public double[] getPos(Node node)
    {
        double[] values = new double[2];

        //"<posattr x="" y=""/>
        Node xNode = node.getAttributes().getNamedItem( "x" );
        values[0] = Double.parseDouble( xNode.getNodeValue().replaceAll( "," , "." ) );

        Node yNode = node.getAttributes().getNamedItem( "y" );
        values[1] = Double.parseDouble( yNode.getNodeValue().replaceAll( "," , "." ) );

        return values;
    }
    
    public String[] getFill(Node node)
    {
        String[] values = new String[3];

        //"<fillattr colour="" pattern="" filled="" />
        Node colourNode = node.getAttributes().getNamedItem( "colour" );
        values[0] = colourNode.getNodeValue();

        Node patternNode = node.getAttributes().getNamedItem( "pattern" );
        values[1] = patternNode.getNodeValue();
        
        Node filledNode = node.getAttributes().getNamedItem( "filled" );
        values[2] = filledNode.getNodeValue();

        return values;
    }
    
    public String[] getLine(Node node)
    {
        String[] values = new String[3];

        //"<lineattr colour="" thick="" type="" />
        Node colourNode = node.getAttributes().getNamedItem( "colour" );
        values[0] = colourNode.getNodeValue();

        Node thickNode = node.getAttributes().getNamedItem( "thick" );
        values[1] = thickNode.getNodeValue();

        Node typeNode = node.getAttributes().getNamedItem( "type" );
        values[2] = typeNode.getNodeValue();

        return values;
    }
    
    public String[] getTextAttr(Node node)
    {
        String[] values = new String[2];

        //"<textattr colour="" bold="" />
        Node colourNode = node.getAttributes().getNamedItem( "colour" );
        values[0] = colourNode.getNodeValue();

        Node boldNode = node.getAttributes().getNamedItem( "bold" );
        values[1] = boldNode.getNodeValue();

        return values;
    }

    public String getText(Node node)
    {
        //"<text> ... </text>
        if( node.getChildNodes().getLength() == 0 )
        {
            return "";
        }
        else
        {
            Node n = node.getChildNodes().item( 0 );
            String value = n.getNodeValue();

            value = value.replace( "&lt;" , "<" );

            return value;
        }
    }
}
