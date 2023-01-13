import java.util.Comparator;

public class HuffmanNode {
    int data;
    String c;

    HuffmanNode left;
    HuffmanNode right;
    public HuffmanNode(){
    }
    public HuffmanNode(String s, int num){
        this.c = s;
        this.data = num;
    }
    public HuffmanNode(HuffmanNode n1, HuffmanNode n2){
        this.data = n1.data + n2.data;
        this.left = n1;
        this.right = n2;
    }
    boolean isLeaf() {
        if (this.left == null && this.right == null) {
            return true;
        }
        return false;
    }
    boolean hasChar(){
        if (this.c != null){
            return true;
        }
        return false;
    }

    public int compare(HuffmanNode y) {
        if (y == null){
            return 0;
        }
        return this.data - y.data;
    }
    public String toString(){
        return c + ":" + data;
    }
}

// comparator class helps to compare the node
// on the basis of one of its attribute.
// Here we will be compared
// on the basis of data values of the nodes.
    class MyComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode x, HuffmanNode y) {
            return x.data - y.data;
        }
    }


