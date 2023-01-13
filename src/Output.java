import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.*;

public class Output {
    public static void output(File filename) throws FileNotFoundException {
        Scanner in;
        PrintStream stream = new PrintStream(new FileOutputStream("output.txt", false));
        try {
            in = new Scanner(filename);
            while(in.hasNext()){
                String temp;
                HuffmanNode node;
                Map<String, Integer> map = new HashMap();
                char[] count;
                int counter = 0;
                double raw = 0;
                double eRatio = 0;
                String num = "";
                StringBuilder encoded = new StringBuilder();
                temp = in.nextLine();
                stream.append("Original : [" + temp + "]" + "\n");
                stream.append("======================================  \n" +
                        "char  frequency  code  \n" +
                        "--------------------------------------");
                stream.append("\n");
                count = temp.toCharArray();
                temp = sortString(temp);
                temp = HuffmanTree.frequency(temp);
                PriorityQueue q;
                q = PriorityQueue.toQueue(temp);
                node = HuffmanTree.toTree(q);
                HuffmanTree.encode(node,"", map,stream);
                for (char c : count) {
                    num = (String.valueOf(map.get(c + "")));
                    if (num!=null) {
                        encoded.append(num);
                    }
                }
                raw = count.length * 8;
                stream.append("======================================" + "\n");
                count = encoded.toString().toCharArray();
                String decoded = HuffmanTree.decode(node,encoded.toString());
                for (int i = 0 ; i < count.length ; i++){
                    eRatio++;
                }
                double ratio = raw / eRatio;
                stream.append("[Encoded bits: " + encoded.toString() + "]" + " [" + eRatio + "]" + "\n");
                stream.append("[Decoded bits: " + decoded + "]" + " [" + raw + "]" + "\n");
                stream.append("[Compression Ratio: " + ratio + "]" + "\n");
                stream.append("\n");
            }
        }catch(FileNotFoundException exception){
            throw new FileNotFoundException("The file input.txt does not exist");
        }
    }
    private static String sortString(String in){
        String returnMe = "";
        char[] temp = in.toCharArray();
        Arrays.sort(temp);
        for(int i = 0; i < temp.length ; i++){
            returnMe += temp[i] + "";
        }
        return returnMe;
    }
}
