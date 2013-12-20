/*

<!ELEMENT binders   (cpnbinder)*>

<!ELEMENT cpnbinder (sheets,zorder?)>
<!ATTLIST cpnbinder id          ID          #IMPLIED
                    x           %number;    #IMPLIED
                    y           %number;    #IMPLIED
                    width       %number;    #IMPLIED
                    height      %number;    #IMPLIED>


<!ELEMENT sheets    (cpnsheet | textsheet)*>

<!ELEMENT zorder    (position)*>

<!ELEMENT position  EMPTY>
<!ATTLIST position  value       %number;    #REQUIRED>


<!ELEMENT cpnsheet  (zorder?)>
<!ATTLIST cpnsheet  id          ID          #IMPLIED
                    panx        %number;    #IMPLIED
                    pany        %number;    #IMPLIED
                    zoom        %number;    #IMPLIED
                    instance    IDREF       #REQUIRED>

<!ELEMENT textsheet (zorder?)>
<!ATTLIST textsheet id          ID          #IMPLIED
                    panx        %number;    #IMPLIED
                    pany        %number;    #IMPLIED
                    zoom        %number;    #IMPLIED
                    decl        IDREF       #REQUIRED>
 
 
 */
package br.cin.ufpe.nesc2cpn.cpnModule.binder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davi
 */
public class Binder {
    
    private long cpnbinderId;
    private double cpnbinderX;
    private double cpnbinderY;
    private double cpnbinderWidth;
    private double cpnbinderHight;
    private List<Cpnsheet> sheets;
    private List<Integer> zorderPosition;

    
    public Binder() {
        this.sheets = new ArrayList<Cpnsheet>();
        this.zorderPosition = new ArrayList<Integer>();
    }

    
    
    
    public double getCpnbinderHight() {
        return cpnbinderHight;
    }

    public void setCpnbinderHight(double cpnbinderHight) {
        this.cpnbinderHight = cpnbinderHight;
    }

    public long getCpnbinderId() {
        return cpnbinderId;
    }

    public void setCpnbinderId(long cpnbinderId) {
        this.cpnbinderId = cpnbinderId;
    }

    public double getCpnbinderWidth() {
        return cpnbinderWidth;
    }

    public void setCpnbinderWidth(double cpnbinderWidth) {
        this.cpnbinderWidth = cpnbinderWidth;
    }

    public double getCpnbinderX() {
        return cpnbinderX;
    }

    public void setCpnbinderX(double cpnbinderX) {
        this.cpnbinderX = cpnbinderX;
    }

    public double getCpnbinderY() {
        return cpnbinderY;
    }

    public void setCpnbinderY(double cpnbinderY) {
        this.cpnbinderY = cpnbinderY;
    }

    public List<Cpnsheet> getSheet() {
        return sheets;
    }

    public void setSheet(List<Cpnsheet> sheet) {
        this.sheets = sheet;
    }

    public List<Integer> getZorderPosition() {
        return zorderPosition;
    }

    public void setZorderPosition(List<Integer> zorderPosition) {
        this.zorderPosition = zorderPosition;
    }

   
    
}