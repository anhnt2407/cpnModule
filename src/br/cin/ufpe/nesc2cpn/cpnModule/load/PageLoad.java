package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.Page;
import org.w3c.dom.Node;

/**
 *
 * @author avld
 */
public class PageLoad
{
    private Page page;
    private Node node;

    public PageLoad(Node node)
    {
        this.node = node;
    }

    public Page getPage()
    {
        page = new Page();
        page.setId( getPageID() );

        for( int i = 0; i < node.getChildNodes().getLength(); i++ )
        {
            Node n = node.getChildNodes().item( i );

            if( "pageattr".equals( n.getNodeName() ) )
            {
                page.setPageattrName( getPageName( n ) );
            }
            if( "trans".equals( n.getNodeName() ) )
            {
                TransLoad load = new TransLoad( n );
                page.getTrans().add( load.getTrans() );
            }
            if( "place".equals( n.getNodeName() ) )
            {
                PlaceLoad load = new PlaceLoad( n );
                page.getPlaces().add( load.getPlace() );
            }
            if( "arc".equals( n.getNodeName() ) )
            {
                ArcLoad load = new ArcLoad( n );
                page.getArcs().add( load.getArc() );
            }
        }

        return page;
    }

    public int getPageID()
    {
        Node idNode = node.getAttributes().getNamedItem( "id" );
        String idStr = idNode.getNodeValue().substring( 2 );

        return Integer.parseInt( idStr );
    }

    public String getPageName(Node node)
    {
        Node nameNode = node.getAttributes().getNamedItem( "name" );
        return nameNode.getNodeValue();
    }
}
