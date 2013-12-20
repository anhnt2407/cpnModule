/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.globbox;

/**
 *
 * @author Davi
 */
public class GlobRef extends BlockItem
{    
    private String ml = "";
    
    public GlobRef()
    {
        setNameId( "" );
        setLayout( "" );
    }

    public GlobRef( String text )
    {
        String[] part = text.replace( ';' , ' ' ).split( "=" );

        setNameId( part[0].split(" ")[1] );
        setMl( part[1] );
        setLayout( text );
    }

    public String getMl()
    {
        return ml;
    }

    public void setMl(String ml)
    {
        this.ml = ml;
    }

    @Override
    public String toString()
    {
        return getLayout();
    }
}
