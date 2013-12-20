/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davi
 */
public class Page {
    private long id;
    private String pageattrName;
    private List<Place> places;
    private List<Trans> trans;
    private List<Arc> arcs;
    
    public Page()
    {
        places = new ArrayList<Place>();
        trans = new ArrayList<Trans>();
        arcs = new ArrayList<Arc>();

        id = IDControl.getInstance().getItemNextId();
    }
    
    public Page(String pageattrName,List<Place> places,List<Trans> trans,List<Arc> arcs){
        id = IDControl.getInstance().getItemNextId();
        this.pageattrName = pageattrName;
        
        this.places = places;
        this.trans = trans;
        this.arcs = arcs;
    }

    public String getPageattrName() {
        return pageattrName;
    }

    public void setPageattrName(String pageattrName) {
        this.pageattrName = pageattrName;
    }

    public List<Arc> getArcs() {
        return arcs;
    }

    public void setArcs(List<Arc> arcs) {
        this.arcs = arcs;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Trans> getTrans() {
        return trans;
    }

    public void setTrans(List<Trans> trans) {
        this.trans = trans;
    }
}
