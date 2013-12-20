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
public class Var extends BlockItem
{
    private List<String> typeIdList;
    private List<String> nameIdList;
    
    public Var ()
    {
        typeIdList = new ArrayList<String>();
        nameIdList = new ArrayList<String>();
    }

    public List<String> getTypeIdList()
    {
        return typeIdList;
    }

    public void setTypeIdList(List<String> typeId)
    {
        this.typeIdList = typeId;
    }

    public List<String> getNameIdList()
    {
        return nameIdList;
    }

    public void setNameIdList(List<String> nameId)
    {
        this.nameIdList = nameId;
    }

    @Override
    public String getNameId()
    {
        return nameIdList.get( 0 );
    }

    @Override
    public void setNameId( String name )
    {
        if( nameIdList.isEmpty() )
        {
            this.nameIdList.add( name );
        }
        else
        {
            this.nameIdList.set( 0 , name );
        }
    }

    @Override
    public String toString()
    {
        return getLayout();
    }
}
