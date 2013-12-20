package br.cin.ufpe.nesc2cpn.cpnModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Davi
 */
public class Trans extends CPNItem
{
    
    private boolean transExplicit = false;
    private double boxW = 60;
    private double boxH = 40;
    //obs no CPNItem o ultimo termo é text e no caso abaixo é o primeiro name
    private CPNItem subpageinfo;
    private double bindingX = 5;
    private double bindingY = 5;
    private CPNItem cond;
    private CPNItem time;
    private CPNItem code;
    private CPNItem channel;
    private CPNItem priority;

    private long portsockId;
    private Map<Long,List<Long>> portsock;

    public Trans(String nome){
        super();
        setText( nome );
        portsock = new HashMap();
    }
    
    public Trans(String nome, CPNItem cond,CPNItem time,CPNItem code,CPNItem channel,CPNItem priority){
        super();
        setText(nome);

        this.cond=cond;
        this.time=time;
        this.code=code;
        this.channel=channel;
        this.priority=priority;
        this.portsock = new HashMap();
    }

    public Trans() {
        super();

        subpageinfo = new CPNItem();
        time = new CPNItem();
        code = new CPNItem();
        channel =new CPNItem();
        portsock = new HashMap();
    }

    @Override
    public void setPosattrX( double x )
    {
        super.setPosattrX( x );
        
        if( subpageinfo != null )
        {
            subpageinfo.setPosattrX( getPosattrX() );
            subpageinfo.setPosattrY( getPosattrY() );
        }
    }
    
    @Override
    public void setPosattrY( double y )
    {
        super.setPosattrY( y );

        if( subpageinfo != null )
        {
            subpageinfo.setPosattrX( getPosattrX() );
            subpageinfo.setPosattrY( getPosattrY() );
        }
    }

    public boolean isTransExplicit() {
        return transExplicit;
    }

    public void setTransExplicit(boolean transExplicit) {
        this.transExplicit = transExplicit;
    }

    public double getBindingX() {
        return bindingX;
    }

    public void setBindingX(double bindingX) {
        this.bindingX = bindingX;
    }

    public double getBindingY() {
        return bindingY;
    }

    public void setBindingY(double bindingY) {
        this.bindingY = bindingY;
    }

    public double getBoxH() {
        return boxH;
    }

    public void setBoxH(double boxH) {
        this.boxH = boxH;
    }

    public double getBoxW() {
        return boxW;
    }

    public void setBoxW(double boxW) {
        this.boxW = boxW;
    }

    public CPNItem getChannel() {
        return channel;
    }

    public void setChannel(CPNItem channel) {
        this.channel = channel;
    }

    public CPNItem getCode() {
        return code;
    }

    public void setCode(CPNItem code)
    {
        if( code != null )
        {
            code.setPosattrX( getPosattrX() + 40 );
            code.setPosattrY( getPosattrY() + 30 );
        }

        this.code = code;
    }

    public CPNItem getCond() {
        return cond;
    }

    public void setCond(CPNItem cond)
    {
        if( cond != null )
        {
            cond.setPosattrX( getPosattrX() );
            cond.setPosattrY( getPosattrY() - 10 );
        }

        this.cond = cond;
    }

    public CPNItem getSubpageinfo() {
        return subpageinfo;
    }

    public void setSubpageinfo(CPNItem subpageinfo) {
        this.subpageinfo = subpageinfo;
    }

    public CPNItem getTime() {
        return time;
    }

    public void setTime(CPNItem time)
    {
        if( time != null )
        {
            time.setPosattrX( getPosattrX() - 10 );
            time.setPosattrY( getPosattrY() - 5 );
        }

        this.time = time;
    }

    public CPNItem getPriority() {
        return priority;
    }

    public void setPriority(CPNItem priority) {
        this.priority = priority;
    }

    public void addPortsock(long id1, long id2)
    {
        if( portsock == null )
        {
            portsock = new HashMap<Long, List<Long>>();
        }

        if( !portsock.containsKey( id1 ) )
        {
            portsock.put( id1 , new ArrayList<Long>() );
        }

        portsock.get( id1 ).add( id2 );
    }

    public Map<Long, List<Long>> getPortSock()
    {
        return portsock;
    }

    public long getPortsockId() {
        return portsockId;
    }

    public void setPortsockId(long portsockId) {
        this.portsockId = portsockId;
    }
    
}
