import java.util.Arrays;

public class BinaryMaxHeap {
    protected int[] heap;
    private int heapSize;
    private final int heapCapacity;

    // this is max-heap (root element is the smallest)
    public BinaryMaxHeap(int capacity) {
        heapSize = 0;
        heapCapacity = capacity;
        heap = new int[capacity];

        // -1 represents null value in array
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == this.heapCapacity;
    }

    /*
    How to get indexes of HeapElements for "i" witch current element:
    Parent      index = (i - 1) / 2
    Left  child index = 2i + 1
    Right child index = 2i + 2
     */

    /**
     * time complexity O(log n)
     */
    private void siftUp(int i) {
        int parentI = (i - 1) / 2;

        // sifting while element not become a root or grater than it's parent
        while ((i != 0) && (this.heap[i] > this.heap[parentI])) {

            // swap current element and parent
            int temp = this.heap[i];
            this.heap[i] = this.heap[parentI];
            this.heap[parentI] = temp;

            // recalculate current element index and it's parent
            i = parentI;
            parentI = (i - 1) / 2;
        }
    }

    /**
     * time complexity O(log n)
     */
    private void siftDown(int i) {
        int leftChildI = 2 * i + 1;
        int rightChildI = 2 * i + 2;
        int biggestChildI;

        // sifting while left or right child exists, and it must be lower than current element
        while ((leftChildI < heapSize && this.heap[i] < heap[leftChildI])
                || (rightChildI < heapSize && this.heap[i] < this.heap[rightChildI])) {

            // find gap or smallest child to put current element
            if ((rightChildI >= heapSize) || this.heap[leftChildI] > this.heap[rightChildI]) {
                biggestChildI = leftChildI;
            } else {
                biggestChildI = rightChildI;
            }

            // swap current element and biggest child
            int temp = heap[i];
            this.heap[i] = this.heap[biggestChildI];
            this.heap[biggestChildI] = temp;

            //recalculating current element child's indexes
            i = biggestChildI;
            leftChildI = 2 * i + 1;
            rightChildI = 2 * i + 2;
        }
    }

    /**
     * time complexity O(log n)
     */
    public void insert(int elementValue) {
        if (this.isFull()) {
            throw new IllegalArgumentException("Can't insert element, Heap already full");
        }
        this.heap[heapSize] = elementValue;
        this.heapSize++;
        this.siftUp(this.heapSize - 1);
    }

    /**
     * time complexity O(1)
     */
    public Integer getMax() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.heap[0];
        }
    }

    /**
     * time complexity O(log n)
     */
    public Integer extractMax() {
        if (this.isEmpty()) {
            return null;
        }
        int rootValue = this.heap[0];

        // swap first and last element
        int temp = this.heap[0];
        this.heap[0] = this.heap[heapSize - 1];
        this.heap[heapSize - 1] = temp;

        // delete last element
        this.heap[heapSize - 1] = -1;
        this.heapSize--;

        // fixing tree
        this.siftDown(0);
        return rootValue;
    }

    /**
     * time complexity O(log n)
     */
    public void updateByIndex(int i, int newValue) {
        // updating value
        int oldValue = this.heap[i];
        this.heap[i] = newValue;

        // fixing tree
        if (newValue > oldValue) {
            this.siftUp(i);
        } else
            this.siftDown(i);
    }

    /**
     * time complexity o(n) due to value search
     */
    public void updateByValue(int oldValue, int newValue) {
        // find first appearing value
        for (int i = 0; i < this.heapSize; i++) {
            if (this.heap[i] == oldValue) {
                // updating this value by index method
                this.updateByIndex(i, newValue);
                break;
            }
        }
    }
}
