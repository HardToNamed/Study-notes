package BPlusTree;

import BPlusTree.INode;
import java.util.ArrayList;

public class TreeLeaf extends INode {
    public ArrayList<Object> values = new ArrayList();
    public TreeLeaf rightBrother = null;

    public TreeLeaf() {
    }
}
