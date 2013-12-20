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
public class Color extends BlockItem
{    
    //private boolean unit = false;
    private List<String> declare;
    private boolean timed = false;
    private With unit;
    private With bool;
    private With inteiro;
    private With real;
    private With string;
    private List<String> enums;
    private Index index;
    private List<String> product;
    private List<RecordField> record;
    private List<String> list;
    private List<Union> union;
    private List<String> alias;
    private Subset subset;
    private List<String> nameIdList;
    
    public Color() {
        super();
        nameIdList = new ArrayList<String>();
//        declare = new ArrayList<String>();
//        unit = new With();
//        bool = new With();
//        inteiro = new With();
//        real = new With();
//        string = new With();
//        enums = new ArrayList<String>();
//        index = new Index();
//        product = new ArrayList<String>();
//        record = new ArrayList<String>();
//        list = new Lister();
//        union = new Union();
//        alias = new ArrayList<String>();
//        subset = new Subset();
    }

    public List<String> getNameIdList() {
        return nameIdList;
    }

    public void setNameIdList(List<String> nameIdList) {
        this.nameIdList = nameIdList;
    }

    @Override
    public String getNameId() {
        return nameIdList.get( 0 );
    }

    @Override
    public void setNameId(String name)
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

    public List<String> getAlias() {
        return alias;
    }

    public void setAlias(List<String> alias) {
        this.alias = alias;
    }

    public With getBool() {
        return bool;
    }

    public void setBool(With bool) {
        this.bool = bool;
    }

    public List<String> getDeclare() {
        return declare;
    }

    public void setDeclare(List<String> declare) {
        this.declare = declare;
    }

    public List<String> getEnums() {
        return enums;
    }

    public void setEnums(List<String> enums) {
        this.enums = enums;
    }

    public Index getIndex() {
        return index;
    }

    public void setIndex(Index index) {
        this.index = index;
    }

    public With getInteiro() {
        return inteiro;
    }

    public void setInteiro(With inteiro) {
        this.inteiro = inteiro;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setList(String list)
    {
        this.list = new ArrayList<String>();
        this.list.add( list );
    }

    public List<String> getProduct() {
        return product;
    }

    public void setProduct(List<String> product) {
        this.product = product;
    }

    public With getReal() {
        return real;
    }

    public void setReal(With real) {
        this.real = real;
    }

    public List<RecordField> getRecord()
    {
        return record;
    }

    public void setRecord(List<RecordField> record)
    {
        this.record = record;
    }

    public With getString() {
        return string;
    }

    public void setString(With string) {
        this.string = string;
    }

    public Subset getSubset() {
        return subset;
    }

    public void setSubset(Subset subset) {
        this.subset = subset;
    }

    public boolean isTimed() {
        return timed;
    }

    public void setTimed(boolean timed) {
        this.timed = timed;
    }

    public List<Union> getUnion() {
        return union;
    }

    public void setUnion(List<Union> union) {
        this.union = union;
    }

    public With getUnit() {
        return unit;
    }

    public void setUnit(With unit) {
        this.unit = unit;
    }

    // ---------------------------------- //
    // ---------------------------------- //
    // ---------------------------------- //

    @Override
    public String toString()
    {
        if( getLayout() != null )
        {
            return getLayout().replace( '\n' , ' ' );
        }

        if( getInteiro() != null )
        {
            return "colset " + toString_nameId() + " : int;";
        }
        else if( getBool() != null )
        {
            return "colset " + toString_nameId() + " : bool;";
        }
        else if( getReal() != null )
        {
            return "colset " + toString_nameId() + " : real;";
        }
        else if( getString() != null )
        {
            return "colset " + toString_nameId() + " : string;";
        }
        else if( getUnit() != null )
        {
            return "colset " + toString_nameId() + " : unit;";
        }
        else
        {
            return null;
        }
    }

    private String toString_nameId()
    {
        String name = "";

        for( int i = 0 ; i < nameIdList.size() ; i++ )
        {
            name += nameIdList.get( i );

            if( i + 1 < nameIdList.size() )
            {
                name += ", ";
            }
        }

        return name;
    }
}
