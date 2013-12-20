/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cin.ufpe.nesc2cpn.cpnModule.IndexNode;

//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Davi
 */
public class IndexNode
{
    private List<IndexNode> indexNode;
    private boolean IndexNodeExpanded = false;

    public IndexNode()
    {
        indexNode = new ArrayList<IndexNode>();
    }

    public IndexNode(boolean expanded)
    {
        indexNode = new ArrayList<IndexNode>();
        this.IndexNodeExpanded = expanded;
    }

    public boolean isIndexNodeExpanded()
    {
        return IndexNodeExpanded;
    }

    public void setIndexNodeExpanded(boolean IndexNodeExpanded)
    {
        this.IndexNodeExpanded = IndexNodeExpanded;
    }

    public List<IndexNode> getIndexNode()
    {
        return indexNode;
    }

    public void setIndexNode(List<IndexNode> indexNode)
    {
        this.indexNode = indexNode;
    }

}
