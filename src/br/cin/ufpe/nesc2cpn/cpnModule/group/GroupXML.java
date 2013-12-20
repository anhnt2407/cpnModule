/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.group;
//import br.cin.ufpe.nesc2cpn.cpn.;



/**
 *
 * @author Davi
 */
public class GroupXML {
    public static String convert(Group group){
        String groupTxt = new String();
        //List<String> group1 = new ArrayList<String>();
        
        groupTxt += "    <group id=\"" + group.getId() + "\"\n";
        groupTxt += "           name=\""+ group.getName() +"\">\n";
        
        for(String group1 : group.getGroupElmIdref() ){
            
            groupTxt +=  "      <group_elm idref=\"" + group1 + "\"/>\n";
        }
        groupTxt += "    </group>\n";
        return groupTxt;
        
        
    }
}
