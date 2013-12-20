package br.cin.ufpe.nesc2cpn.cpnModule;

/**
 *
 * @author avld
 */
public class Place extends CPNItem {
    public static final String PORT_TYPE_IN = "In";
    public static final String PORT_TYPE_OUT = "Out";
    public static final String PORT_TYPE_IO = "I/O";

    //<text>ligado</text>
    //private String text;

    //<ellipse w="84,000000" h="48,000000"/>
    private double ellipseWidth    = 60.0;
    private double ellipseHeight   = 40.0;

    //<token x="-56,000000" y="0,000000"/>
    private double tokenX = 0.0;
    private double tokenY = 0.0;

    //<marking x="-12,000000" y="36,000000" hidden="false">
    private double markingX = 0.0;
    private double markingY = 0.0;
    private boolean markingHidden  = false;
    
    //   <snap snap_id="0" anchor.horizontal="3" anchor.vertical="2"/>
    private long snapId =0;
    private int snapHorizontal = 0;
    private int snapVertical = 0;
    //</marking>

    //<text tool="CPN Tools" version="2.3.4">INT</text>
    private CPNItem type;

    //<text tool="CPN Tools" version="2.3.4">0</text>
    private CPNItem initmark;

    private CPNItem portType;

    public Place(){
        super();
       
//        this.setId(super.idAuto());
//        this.setPosattrX(super.posattrXAuto());
//        this.setPosattrY(super.posattrYAuto());
        type = new CPNItem();
        initmark = new CPNItem();
    }

    public Place(String nome){
        super();
//        this.setId(super.idAuto());
//        this.setPosattrX(super.posattrXAuto());
//        this.setPosattrY(super.posattrYAuto());
        setText( nome );
    }
    
    public Place(String nome,CPNItem type,CPNItem initmark){
        super();
        
        this.setText( nome );
//        this.setId(super.idAuto());
//        this.setPosattrX(super.posattrXAuto());
//        this.setPosattrY(super.posattrYAuto());
        this.type = type;
        this.initmark = initmark;
                
    }

    public double getEllipseHeight() {
        return ellipseHeight;
    }

    public void setEllipseHeight(double ellipseHeight) {
        this.ellipseHeight = ellipseHeight;
    }

    public double getEllipseWidth() {
        return ellipseWidth;
    }

    public void setEllipseWidth(double ellipseWidth) {
        this.ellipseWidth = ellipseWidth;
    }

    public CPNItem getInitmark() {
        return initmark;
    }

    public void setInitmark(CPNItem initmark) {
        if( initmark != null )
        {
            initmark.setPosattrX( getPosattrX() + 30 );
            initmark.setPosattrY( getPosattrY() + 30 );
        }

        this.initmark = initmark;
    }

    public boolean isMarkingHidden() {
        return markingHidden;
    }

    public void setMarkingHidden(boolean markingHidden) {
        this.markingHidden = markingHidden;
    }

    public double getMarkingX() {
        return markingX;
    }

    public void setMarkingX(double markingX) {
        this.markingX = markingX;
    }

    public double getMarkingY() {
        return markingY;
    }

    public void setMarkingY(double markingY) {
        this.markingY = markingY;
    }

    public int getSnapHorizontal() {
        return snapHorizontal;
    }

    public void setSnapHorizontal(int snapHorizontal) {
        this.snapHorizontal = snapHorizontal;
    }

    public long getSnapId() {
        return snapId;
    }

    public void setSnapId(long snapId) {
        this.snapId = snapId;
    }

    public int getSnapVertical() {
        return snapVertical;
    }

    public void setSnapVertical(int snapVertical) {
        this.snapVertical = snapVertical;
    }

    public double getTokenX() {
        return tokenX;
    }

    public void setTokenX(double tokenX) {
        this.tokenX = tokenX;
    }

    public double getTokenY() {
        return tokenY;
    }

    public void setTokenY(double tokenY) {
        this.tokenY = tokenY;
    }

    public CPNItem getType() {
        return type;
    }

    public void setType(CPNItem type) {
        if( type != null )
        {
            type.setPosattrX( getPosattrX() + 30 );
            type.setPosattrY( getPosattrY() - 30 );
        }

        this.type = type;
    }

    public CPNItem getPortType() {
        return portType;
    }

    public void setPortType(String typr) {
        setPortType( new CPNItem( typr ) );
    }

    public void setPortType(CPNItem portType)
    {
        if( portType != null )
        {
            portType.setPosattrX( getPosattrX() - 10 );
            portType.setPosattrY( getPosattrY() - 20 );
        }

        this.portType = portType;
    }

}
