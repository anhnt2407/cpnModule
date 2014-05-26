package br.cin.ufpe.nesc2cpn.cpnModule.load;

import br.cin.ufpe.nesc2cpn.cpnModule.CPN;
import br.cin.ufpe.nesc2cpn.cpnModule.IndexNode.IndexNode;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author avld
 */
public class CpnLoad
{
    private CPN cpn;
    private Node nodeRoot;

    public CpnLoad( String filename ) throws Exception
    {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse( filename );
        doc.getDocumentElement().normalize();

        nodeRoot = doc.getDocumentElement();
    }

    public CPN getCpn()
    {
        cpn = new CPN();

        for(int i = 0; i < nodeRoot.getChildNodes().getLength(); i++ )
        {
            Node node = nodeRoot.getChildNodes().item( i );

            if( "cpnet".equals( node.getNodeName() ) )
            {
                threat( node );
            }
        }

        return cpn;
    }

    public void threat(Node node)
    {
        for(int i = 0; i < node.getChildNodes().getLength(); i++ )
        {
            Node n = node.getChildNodes().item( i );

            if( "page".equalsIgnoreCase( n.getNodeName() ) )
            {
                PageLoad load = new PageLoad( n );
                cpn.getPage().add( load.getPage() );
            }
            else if( "monitorblock".equalsIgnoreCase( n.getNodeName() ) )
            {
                processMonitorBlock( n );
            }
            else if( "instances".equalsIgnoreCase( n.getNodeName() ) )
            {
                processInstances( n );
            }
            else if( "IndexNode".equalsIgnoreCase( n.getNodeName() ) )
            {
                IndexNodeLoad load = new IndexNodeLoad( n );
                cpn.setIndexNode( load.getIndexNode() );
            }
            else if( "globbox".equalsIgnoreCase( n.getNodeName() ) )
            {
                GlobboxLoad load = new GlobboxLoad( n );
                cpn.setGlobbox( load.getGlobBox() );
            }
        }
    }

    private void processMonitorBlock( Node node )
    {
        NodeList list = node.getChildNodes();
        for( int i = 0; i < list.getLength() ; i++ )
        {
            Node n = list.item( i );
            
            if( "monitor".equalsIgnoreCase( n.getNodeName() ) )
            {
                MonitorLoad loader = new MonitorLoad( n );
                cpn.getMonitors().getMonitor().add( loader.getMonitor() );
            }
        }
    }

    private void processInstances( Node node )
    {
        NodeList list = node.getChildNodes();
        for( int i = 0; i < list.getLength() ; i++ )
        {
            Node n = list.item( i );
            
            if( "instance".equalsIgnoreCase( n.getNodeName() ) )
            {
                InstanceLoad loader = new InstanceLoad( n );
                cpn.getInstances().add( loader.getInstanceItens() );
            }
        }
    }
    
    private static String getIndexNodeString( String espaco , IndexNode index )
    {
        String txt = espaco + index.isIndexNodeExpanded() + "\n";

        for( IndexNode indexChildren : index.getIndexNode() )
        {
            txt += getIndexNodeString( espaco + " " , indexChildren );
        }

        return txt;
    }

}
