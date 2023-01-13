public class PriorityQueue extends ArrayHeap {
    private static final int MAX_SIZE = 50;

    public PriorityQueue() {
        super(MAX_SIZE);
    }

    public void enqueue(HuffmanNode data) {
        super.add(data);
    }

    // returns the  minimum item of the heap
    public HuffmanNode peek() {
        return super.peek();
    }

    // deletes the max item and return
    public HuffmanNode dequeue() {
        return super.removeMin();
    }

    public static PriorityQueue toQueue(String frequency){
        PriorityQueue queue = new PriorityQueue();
        char[] arr = frequency.toCharArray();
        for (int i = 0; i < arr.length ; i += 2){
            String s =arr[i]+"";
            int n = Integer.parseInt(arr[i+1] + "");
            HuffmanNode node = new HuffmanNode(s,n);
            queue.enqueue(node);
        }
        return queue;
    }

}
