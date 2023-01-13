import java.util.Arrays;

public class ArrayHeap extends HuffmanNode {
    public HuffmanNode[] heap;
    private int index;
    private int size;

    public ArrayHeap(int size) {
        this.size = size;
        this.index = 0;
        heap = new HuffmanNode[size];
    }
    public int getIndex() {return index;}
    private int parent(int i) {return (i - 1) / 2; }
    private int leftChild(int i) {return (i * 2) + 1; }
    private int rightChild(int i) {return (i * 2) + 2;}

    private boolean isLeaf(int i) {
        if (rightChild(i) >= size || leftChild(i) >= size) {
            return true;
        }
        return false;
    }

    public void add(HuffmanNode element) {
        if (index >= size) {
            return;
        }
        heap[index] = element;
        int current = index;
        while (heap[current].compare(heap[parent(current)]) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
        minHeapify(0);
        index++;
    }

    public HuffmanNode removeMin() {
        HuffmanNode popped = heap[0];
        HuffmanNode temp = heap[index-1];
        heap[0] = temp;
        heap[index-1] = null;
        minHeapify(0);
        index--;
        return popped;
    }

    private void minHeapify(int i) {
        if (!isLeaf(i)) {
            if (heap[leftChild(i)] == null || heap[rightChild(i)] == null){
                return;
            }
            if (heap[i].compare(heap[leftChild(i)]) > 0 || heap[i].compare(heap[rightChild(i)]) > 0) {
                if (heap[leftChild(i)].compare(heap[rightChild(i)]) < 0) {
                    swap(i, leftChild(i));
                    minHeapify(leftChild(i));
                } else {
                    swap(i, rightChild(i));
                    minHeapify(rightChild(i));
                }
            }
        }
    }
    public HuffmanNode peek(){
        return heap[0];
    }
    public String toString(){
        return Arrays.toString(heap);
    }

    private void swap(int x, int y) {
        HuffmanNode tmp;
        tmp = heap[x];
        heap[x] = heap[y];
        heap[y] = tmp;
    }
}
