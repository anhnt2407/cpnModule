/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davi
 */
public class Ml extends BlockItem {
    
    private List<String> listLayout;
    private List<String> pcData;
    
    public Ml(){
        listLayout = new ArrayList<String>();
        pcData = new ArrayList<String>();
    }

    public Ml(String layout){
        listLayout = new ArrayList<String>();
        listLayout.add( layout );

        pcData = new ArrayList<String>();
    }
  
    public List<String> getlistLayout() {
        return listLayout;
    }

    public void setlistLayout(List<String> layout) {
        this.listLayout = layout;
    }

    public List<String> getPcData() {
        return pcData;
    }

    public void setPcData(List<String> pcData) {
        this.pcData = pcData;
    }
    
    @Override
    public void setLayout(String layout)
    {
        this.listLayout.add( layout );
    }
    
    @Override
    public String getLayout()
    {
        if( this.listLayout.isEmpty() )
        {
            return null;
        }
        
        return this.listLayout.get( 0 );
    }
    
    @Override
    public String toString()
    {
        return getLayout().replace( '\n' , ' ' );
    }
}
