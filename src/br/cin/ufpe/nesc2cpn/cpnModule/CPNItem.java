package br.cin.ufpe.nesc2cpn.cpnModule;

//<posattr .../> <!-- position -->
//<fillattr .../> <!-- fill color -->
//<lineattr .../> <!-- line width and color -->
//<textattr .../> <!-- font and text color -->

/**
 *
 * @author avld
 */
public class CPNItem {
    //<place id="ID89764">
//    private static long ID=0;
//    private static double POSATTRX=-260;
//    private static double POSATTRY=165; 
    
    private long id;

    private double posattrX ;
    private double posattrY ;
    
    private String  fillattrColor        = "White";
    private String  fillattrPattern      = "";
    private boolean fillattrFilled       = false;

    private String lineattrColor         = "Black";
    private int lineattrThick            = 1;
    private String lineattrType          = "Solid";

    private String textattrColour       = "Black";
    private boolean textattrBold        = false;

    private String text;
    
    public CPNItem()
    {
        id = IDControl.getInstance().getItemNextId();
        posattrX = 0;
        posattrY = 0;
    }

    public CPNItem(String text)
    {
        id = IDControl.getInstance().getItemNextId();
        posattrX = 0;
        posattrY = 0;
        
        this.text = text;
    }
    
    public CPNItem(int x, int y)
    {
        id = IDControl.getInstance().getItemNextId();
        posattrX = x;
        posattrY = y;
    }
    
//    public void idAuto(){
//        ID=ID+1;
//        //return ID;
//    }
//    
//    public double posattrXAuto(){
//        POSATTRX=POSATTRX+5;
//        return POSATTRX;
//    }
//    
//    public double posattrYAuto(){
//        POSATTRY=POSATTRY+5;
//        return POSATTRY;
//    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFillattrColor() {
        return fillattrColor;
    }

    public void setFillattrColor(String fillattrColor) {
        this.fillattrColor = fillattrColor;
    }

    public boolean isFillattrFilled() {
        return fillattrFilled;
    }

    public void setFillattrFilled(boolean fillattrFilled) {
        this.fillattrFilled = fillattrFilled;
    }

    public String getFillattrPattern() {
        return fillattrPattern;
    }

    public void setFillattrPattern(String fillattrPattern) {
        this.fillattrPattern = fillattrPattern;
    }

    public String getLineattrColor() {
        return lineattrColor;
    }

    public void setLineattrColor(String lineattrColor) {
        this.lineattrColor = lineattrColor;
    }

    public int getLineattrThick() {
        return lineattrThick;
    }

    public void setLineattrThick(int lineattrThick) {
        this.lineattrThick = lineattrThick;
    }

    public String getLineattrType() {
        return lineattrType;
    }

    public void setLineattrType(String lineattrType) {
        this.lineattrType = lineattrType;
    }

    public double getPosattrX() {
        return posattrX;
    }

    public void setPosattrX(double posattrX) {
        this.posattrX = posattrX;
    }

    public double getPosattrY() {
        return posattrY;
    }

    public void setPosattrY(double posattrY) {
        this.posattrY = posattrY;
    }

    public boolean isTextattrBold() {
        return textattrBold;
    }

    public void setTextattrBold(boolean textattrBold) {
        this.textattrBold = textattrBold;
    }

    public String getTextattrColour() {
        return textattrColour;
    }

    public void setTextattrColour(String textattrColour) {
        this.textattrColour = textattrColour;
    }
}
