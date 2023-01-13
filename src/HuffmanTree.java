import java.io.PrintStream;
import java.util.Map;

public class HuffmanTree extends PriorityQueue{
    public static void encode(HuffmanNode root, String s, Map map, PrintStream stream) {
        if (root.isLeaf() && root.hasChar()){
            stream.append(root.c + "    |    " + root.data +"    |    " + s + "\n");
            map.put(root.c, s);
            return;
        }
        if (root.left != null) {
            encode(root.left, s + "0", map,stream);
        }
        if (root.right !=null) {
            encode(root.right, s + "1", map,stream);
        }
    }
    public static String decode(HuffmanNode root, String s) {
        String decoded = "";
        HuffmanNode curr = root;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '0')
                curr = curr.left;
            else
                curr = curr.right;
            if (curr.isLeaf())
            {
                decoded += curr.c;
                curr = root;
            }
        }
        return decoded;
    }
    public static String frequency(String list){
        StringBuilder returnString = new StringBuilder();
        char[] input = list.toCharArray();
        int count = 0;
        char holder = 0;
        for (int i = 0; i < input.length ; i++){
            if(i == input.length - 1){
                holder = input[i];
                count++;
                returnString.append(holder).append(count);
                return returnString.toString();
            }
            if(input[i] == input[i+1]){
                count++;
            }else{
                holder = input[i];
                count++;
                returnString.append(holder).append(count);
                count = 0;
            }
        }
        return returnString.toString();
    }
    public static HuffmanNode toTree(PriorityQueue q){
        HuffmanNode n1 ;
        HuffmanNode n2 ;
        while (q.getIndex()>1){
            n1 = q.dequeue();
            if (n1.hasChar()) {
                n1.left = null;
                n1.right = null;
            }
            n2 = q.dequeue();
            if (n2.hasChar()) {
                n2.left = null;
                n2.right = null;
            }
            HuffmanNode temp = new HuffmanNode(n1,n2);
            q.enqueue(temp);
        }
        return q.dequeue();
    }
}
