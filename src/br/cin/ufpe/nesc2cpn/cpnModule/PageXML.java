package br.cin.ufpe.nesc2cpn.cpnModule;

/**
 *
 * @author Davi
 */
public class PageXML {
    public static String convert(Page page){
        String pageTxt = "\n";
        pageTxt += "    <page id=\"ID" + page.getId() + "\">\n";
        pageTxt += "      <pageattr name=\"" + page.getPageattrName()+"\"/>\n";
        
        for( Place place : page.getPlaces() )
        {
            pageTxt += PlaceXML.convert( place );
        }
        
        for( Trans trans : page.getTrans() )
        {
            pageTxt += TransXML.convert( trans );
        }
        
        for( Arc arc : page.getArcs() )
        {
            pageTxt += ArcXML.convert( arc );
        }
        
        pageTxt += "    </page>\n";
        
        return pageTxt;
        
    }
    
}
