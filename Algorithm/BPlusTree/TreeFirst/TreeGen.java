
package BPlusTree;

import BPlusTree.INode;
import BPlusTree.TreeLeaf;
import BPlusTree.TreeNode;
import java.util.ArrayList;
import java.util.Iterator;

public class TreeGen {
    private int _m = 4;
    private int _min = 2;
    private INode _rootNode = new TreeLeaf();
    private INode _research_result = null;
    private TreeLeaf _leaf_tmp = null;

    public int getM() {
        return this._m;
    }

    public int getMin() {
        return this._min;
    }

    public TreeGen(int m) {
        this._m = m;
        this._min = (int)Math.ceil((double)this._m / 2.0D);
    }

    public static TreeGen getCopyGen(TreeGen gen) {
        TreeGen _gen1 = new TreeGen(gen.getM());
        ArrayList arrList = gen.getAllKeyList();
        Iterator iterator = arrList.iterator();

        while(iterator.hasNext()) {
            Comparable key = (Comparable)iterator.next();
            _gen1.insert(key);
        }

        return _gen1;
    }

    public void setGen(int m, int min, INode inode) {
        this._m = m;
        this._min = min;
        this._rootNode = inode;
    }

    public INode getRootNode() {
        return this._rootNode;
    }

    public boolean insert(Comparable indexNO) {
        TreeLeaf theLeaf;
        int indexLOC;
        if(this._rootNode.childNodes.size() <= 0) {
            if(!this._rootNode.isLeaf) {
                theLeaf = new TreeLeaf();
                theLeaf.isLeaf = true;
                Iterator iterator = this._rootNode.keys.iterator();

                while(iterator.hasNext()) {
                    Comparable var8 = (Comparable)iterator.next();
                    theLeaf.keys.add(var8);
                }

                this._rootNode = theLeaf;
            }

            int var7 = -1;
            indexLOC = 0;
            Iterator iterator = this._rootNode.keys.iterator();

            while(true) {
                if(iterator.hasNext()) {
                    Comparable var10 = (Comparable)iterator.next();
                    if(var10.equals(indexNO) ){
                        return false;
                    }

                    if(indexNO.compareTo(var10) > 0) {
                        var7 = indexLOC;
                    }

                    if(indexNO.compareTo(var10) >= 0) {
                        ++indexLOC;
                        continue;
                    }
                }

                this._rootNode.keys.add(var7 + 1, indexNO);
                this.recurse_division_after_insert(this._rootNode);
                return true;
            }
        } else {
            theLeaf = this.recursion_search_suitable_leaf(this._rootNode, indexNO);
            if(theLeaf == null) {
                return false;
            } else {
                indexLOC = -1;
                int cindex = 0;
                Iterator iterator = theLeaf.keys.iterator();

                while(true) {
                    if(iterator.hasNext()) {
                        Comparable f1 = (Comparable)iterator.next();
                        if(f1.equals(indexNO)) {
                            return false;
                        }

                        if(indexNO.compareTo(f1) > 0) {
                            indexLOC = cindex;
                        }

                        if(indexNO.compareTo(f1) >= 0) {
                            ++cindex;
                            continue;
                        }
                    }

                    this.insertIndexNO(theLeaf, indexNO);
                    if(indexLOC == -1) {
                        this.recursion_changeMinimun(theLeaf, indexNO);
                    }

                    this.recurse_division_after_insert(theLeaf);
                    return true;
                }
            }
        }
    }

    public boolean insert(Comparable indexNO, Object value) {
        TreeLeaf theLeaf;
        int indexLOC;
        if(this._rootNode.childNodes.size() <= 0) {
            if(!this._rootNode.isLeaf) {
                theLeaf = new TreeLeaf();
                theLeaf.isLeaf = true;
                Iterator iterator = this._rootNode.keys.iterator();

                while(iterator.hasNext()) {
                    Comparable var8 = (Comparable)iterator.next();
                    theLeaf.keys.add(var8);
                }

                this._rootNode = theLeaf;
            }

            int var7 = -1;
            indexLOC = 0;
            Iterator iterator = this._rootNode.keys.iterator();

            while(true) {
                if(iterator.hasNext()) {
                    Comparable var10 = (Comparable)iterator.next();
                    if(var10.equals(indexNO) ){
                        return false;
                    }

                    if(indexNO.compareTo(var10) > 0) {
                        var7 = indexLOC;
                    }

                    if(indexNO.compareTo(var10) >= 0) {
                        ++indexLOC;
                        continue;
                    }
                }

                this._rootNode.keys.add(var7 + 1, indexNO);
                ((TreeLeaf)this._rootNode).values.add(var7 + 1, value);
                this.recurse_division_after_insert(this._rootNode);
                return true;
            }
        } else {
            theLeaf = this.recursion_search_suitable_leaf(this._rootNode, indexNO);
            if(theLeaf == null) {
                return false;
            } else {
                indexLOC = -1;
                int cindex = 0;
                Iterator iterator = theLeaf.keys.iterator();

                while(true) {
                    if(iterator.hasNext()) {
                        Comparable f1 = (Comparable)iterator.next();
                        if(f1.equals(indexNO)) {
                            return false;
                        }

                        if(indexNO.compareTo(f1) > 0) {
                            indexLOC = cindex;
                        }

                        if(indexNO.compareTo(f1) >= 0) {
                            ++cindex;
                            continue;
                        }
                    }

                    this.insertIndexNO(theLeaf, indexNO, value);
                    if(indexLOC == -1) {
                        this.recursion_changeMinimun(theLeaf, indexNO);
                    }

                    this.recurse_division_after_insert(theLeaf);
                    return true;
                }
            }
        }
    }

    public INode search(Comparable indexNO) {
        this._research_result = null;
        this.recursion_to_serach(this._rootNode, indexNO);
        return this._research_result;
    }

    private void recursion_to_serach(INode currentNode, Comparable indexNO) {
        if(currentNode != null) {
            int cindex;
            Comparable key;
            Iterator iterator;
            if(!currentNode.isLeaf && currentNode.childNodes.size() > 0) {
                int var7 = -1;
                cindex = 0;

                for(iterator = currentNode.keys.iterator(); iterator.hasNext(); ++cindex) {
                    key = (Comparable) iterator.next();
                    if(indexNO.compareTo(key) < 0) {
                        break;
                    }

                    if(indexNO.compareTo(key ) >= 0) {
                        var7 = cindex;
                    }
                }

                if(var7 != -1) {
                    this.recursion_to_serach((INode)currentNode.childNodes.get(var7), indexNO);
                }
            } else {
                boolean indexLoc = true;
                cindex = 0;

                for(iterator = currentNode.keys.iterator(); iterator.hasNext(); ++cindex) {
                    key = (Comparable) iterator.next();
                    if(indexNO.equals(key)) {
                        this._research_result = currentNode;
                        break;
                    }
                }

            }
        }
    }

    private void recursion_changeMinimun(INode currentNode, Comparable indexNO) {
        if(currentNode != null) {
            if(! currentNode.keys.get(0).equals(indexNO)) {
                currentNode.keys.remove(0);
                currentNode.keys.add(0, indexNO);
            }

            this.recursion_changeMinimun(currentNode.parent, indexNO);
        }
    }

    private boolean insertIndexNO(INode currentNode, Comparable indexNO) {
        if(currentNode == null) {
            return false;
        } else {
            int indexLOC = -1;
            int cindex = 0;
            Iterator iterator = currentNode.keys.iterator();

            while(true) {
                if(iterator.hasNext()) {
                    Comparable f1 = (Comparable) iterator.next();
                    if(f1.equals(indexNO)) {
                        return false;
                    }

                    if(indexNO.compareTo(f1) > 0) {
                        indexLOC = cindex;
                    }

                    if(indexNO.compareTo(f1) >= 0) {
                        ++cindex;
                        continue;
                    }
                }

                currentNode.keys.add(indexLOC + 1, indexNO);
                return true;
            }
        }
    }
    private boolean insertIndexNO(INode currentNode, Comparable indexNO, Object value) {
        if(currentNode == null) {
            return false;
        } else {
            int indexLOC = -1;
            int cindex = 0;
            Iterator iterator = currentNode.keys.iterator();

            while(true) {
                if(iterator.hasNext()) {
                    Comparable f1 = (Comparable) iterator.next();
                    if(f1.equals(indexNO)) {
                        return false;
                    }

                    if(indexNO.compareTo(f1) > 0) {
                        indexLOC = cindex;
                    }

                    if(indexNO.compareTo(f1) >= 0) {
                        ++cindex;
                        continue;
                    }
                }

                currentNode.keys.add(indexLOC + 1, indexNO);
                ((TreeLeaf)currentNode).values.add(indexLOC+1, value);
                return true;
            }
        }
    }
    private TreeLeaf recursion_search_suitable_leaf(INode currentNode, Comparable indexNO) {
        if(currentNode == null) {
            return null;
        } else if(!currentNode.isLeaf && currentNode.childNodes.size() > 0) {
            int indexLoc = -1;
            int cindex = 0;

            for(Iterator iterator = currentNode.keys.iterator(); iterator.hasNext(); ++cindex) {
                Comparable iNO = (Comparable) iterator.next();
                if(indexNO.compareTo(iNO) < 0) {
                    break;
                }

                if(indexNO.compareTo(iNO) > 0) {
                    indexLoc = cindex;
                }

                if(indexNO.equals(iNO)) {
                    return null;
                }
            }

            return indexLoc == -1?this.recursion_getLeftLeaf(currentNode):this.recursion_search_suitable_leaf((INode)currentNode.childNodes.get(indexLoc), indexNO);
        } else {
            return (TreeLeaf)currentNode;
        }
    }

    private TreeLeaf recursion_getLeftLeaf(INode currentNode) {
        return currentNode == null?null:(currentNode.isLeaf?(TreeLeaf)currentNode:(currentNode.childNodes.size() <= 0?null:this.recursion_getLeftLeaf((INode)currentNode.childNodes.get(0))));
    }
