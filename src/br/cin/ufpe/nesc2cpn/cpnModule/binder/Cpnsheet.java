/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.binder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davi
 */
public class Cpnsheet {
    
    private long cpnsheetId;
    private double cpnsheetPanx;
    private double cpnsheetPany;
    private double cpnsheetZoom;
    private long cpnsheetInstance = 0;
    private long cpnsheetDecl = 0;
    private List<Integer> zorderPosition;
    
    public Cpnsheet(){
        zorderPosition = new ArrayList<Integer>();
        
    }

    public long getCpnsheetDecl() {
        return cpnsheetDecl;
    }

    public void setCpnsheetDecl(long cpnsheetDecl) {
        this.cpnsheetDecl = cpnsheetDecl;
    }

    public long getCpnsheetId() {
        return cpnsheetId;
    }

    public void setCpnsheetId(long cpnsheetId) {
        this.cpnsheetId = cpnsheetId;
    }

    public long getCpnsheetInstance() {
        return cpnsheetInstance;
    }

    public void setCpnsheetInstance(long cpnsheetInstance) {
        this.cpnsheetInstance = cpnsheetInstance;
    }

    public double getCpnsheetPanx() {
        return cpnsheetPanx;
    }

    public void setCpnsheetPanx(double cpnsheetPanx) {
        this.cpnsheetPanx = cpnsheetPanx;
    }

    public double getCpnsheetPany() {
        return cpnsheetPany;
    }

    public void setCpnsheetPany(double cpnsheetPany) {
        this.cpnsheetPany = cpnsheetPany;
    }

    public double getCpnsheetZoom() {
        return cpnsheetZoom;
    }

    public void setCpnsheetZoom(double cpnsheetZoom) {
        this.cpnsheetZoom = cpnsheetZoom;
    }

    public List<Integer> getZorderPosition() {
        return zorderPosition;
    }

    public void setZorderPosition(List<Integer> zorderPosition) {
        this.zorderPosition = zorderPosition;
    }
    
    
    
}
