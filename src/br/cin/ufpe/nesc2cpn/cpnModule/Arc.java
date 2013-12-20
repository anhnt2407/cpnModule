package br.cin.ufpe.nesc2cpn.cpnModule;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davi
 */
public class Arc extends CPNItem {
    public static String TransitionToPlace = "TtoP";
    public static String PlaceToTransition = "PtoT";
    public static String BOTHDIR = "BOTHDIR";

    private  String orientation = PlaceToTransition;
    private int order = 0;
    private double arrowattrHeadsize= 1.200000;
    private int arrowattrCurrentcyckle = 2;
    private long transendIdref;
    private long placeendIdref;
    private List<CPNItem> bendpointList;
    private CPNItem annot;

    public Arc() {
        super();
        
        annot = new CPNItem();
        setPosattrX(0);
        setPosattrY(0);

        bendpointList = new ArrayList<CPNItem>();
    }
    
    public Arc(Trans transendIdref,Place placeendIdref,CPNItem annot,String seta) {
        super();
        //setText( nome );
//        setId(super.idAuto());
        setPosattrX(0);
        setPosattrY(0);
        
        this.orientation = seta;
        this.transendIdref = transendIdref.getId();
        this.placeendIdref = placeendIdref.getId();
        this.annot = annot;

        bendpointList = new ArrayList<CPNItem>();
    }
    
    public Arc(String nome) { 
        super();
        
        setPosattrX( 0 );
        setPosattrY( 0 );
        setText( nome );

        bendpointList = new ArrayList<CPNItem>();
    }

    public List<CPNItem> getBendpointList()
    {
        return bendpointList;
    }

    public void setBendpointList(List<CPNItem> bendpoint)
    {
        this.bendpointList = bendpoint;
    }

    public CPNItem getAnnot() {
        return annot;
    }

    public void setAnnot(CPNItem annot)
    {
        this.annot = annot;
    }

    public int getArrowattrCurrentcyckle() {
        return arrowattrCurrentcyckle;
    }

    public void setArrowattrCurrentcyckle(int arrowattrCurrentcyckle) {
        this.arrowattrCurrentcyckle = arrowattrCurrentcyckle;
    }

    public double getArrowattrHeadsize() {
        return arrowattrHeadsize;
    }

    public void setArrowattrHeadsize(double arrowattrHeadsize) {
        this.arrowattrHeadsize = arrowattrHeadsize;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public long getPlaceendIdref() {
        return placeendIdref;
    }

    public void setPlaceendIdref(long placeendIdref) {
        this.placeendIdref = placeendIdref;
    }

    public long getTransendIdref() {
        return transendIdref;
    }

    public void setTransendIdref(long transendIdref) {
        this.transendIdref = transendIdref;
    }
    
}
