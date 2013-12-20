package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.Place;
import org.w3c.dom.Node;

/**
 *
 * @author avld
 */
public class PlaceLoad extends CpnItemLoad
{
    private Place place;

    public PlaceLoad(Node node)
    {
        super( new Place() , node );
        place = (Place) cpnItem;
    }

    public Place getPlace()
    {
        return (Place) getCpnItem();
    }

    @Override
    public void foundExtraNode( Node n )
    {
        if( "ellipse".equals( n.getNodeName() ) )
        {
            double[] values = getEllipse( n );

            place.setEllipseWidth( values[0] );
            place.setEllipseHeight( values[1] );
        }
        else if( "port".equals( n.getNodeName() ) )
        {
            setPort( n );
        }
        else if( "token".equals( n.getNodeName() ) )
        {
            double[] values = getToken( n );

            place.setTokenX( values[0] );
            place.setTokenY( values[1] );
        }
        else if( "type".equals( n.getNodeName() ) )
        {
            CpnItemLoad load = new CpnItemLoad( n );
            place.setType( load.getCpnItem() );
        }
        else if( "initmark".equals( n.getNodeName() ) )
        {
            CpnItemLoad load = new CpnItemLoad( n );
            place.setInitmark( load.getCpnItem() );
        }
    }

    public double[] getEllipse(Node node)
    {
        double[] values = new double[2];

        //"<ellipse w="" h=""/>
        Node wNode = node.getAttributes().getNamedItem( "w" );
        values[0] = Double.parseDouble( wNode.getNodeValue().replace( "," , "." ) );

        Node hNode = node.getAttributes().getNamedItem( "h" );
        values[1] = Double.parseDouble( hNode.getNodeValue().replace( "," , "." ) );

        return values;
    }

    public double[] getToken(Node node)
    {
        double[] values = new double[2];

        //"<token x="" y=""/>
        Node xNode = node.getAttributes().getNamedItem( "x" );
        values[0] = Double.parseDouble( xNode.getNodeValue().replace( "," , "." ) );

        Node yNode = node.getAttributes().getNamedItem( "y" );
        values[1] = Double.parseDouble( yNode.getNodeValue().replace( "," , "." ) );

        return values;
    }
    
    public void setPort(Node node)
    {
        String value = node.getAttributes().getNamedItem( "type" ).getNodeValue();
        place.setPortType( value );
    }
}
