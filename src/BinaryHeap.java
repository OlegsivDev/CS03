import java.util.Arrays;

public class BinaryHeap {
    protected int[] heap;
    private int heapSize;

    // this is min-heap (root element is the smallest)
    public BinaryHeap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];

        // -1 represents null value in array
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
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

        // sifting while element not become a root or smaller than it's parent
        while ((i != 0) && (this.heap[i] < this.heap[parentI])) {

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
        int smallestChildI;

        // sifting while left or right child exists, and it must be higher than current element
        while ((leftChildI < heapSize && this.heap[i] > heap[leftChildI])
                || (rightChildI < heapSize && this.heap[i] > this.heap[rightChildI])) {

            // find gap or smallest child to put current element
            if ((rightChildI >= heapSize) || this.heap[leftChildI] < this.heap[rightChildI]) {
                smallestChildI = leftChildI;
            } else {
                smallestChildI = rightChildI;
            }

            // swap current element and smallest child
            int temp = heap[i];
            this.heap[i] = this.heap[smallestChildI];
            this.heap[smallestChildI] = temp;

            //recalculating current element child's indexes
            i = smallestChildI;
            leftChildI = 2 * i + 1;
            rightChildI = 2 * i + 2;
        }
    }

    /**
     * time complexity O(log n)
     */
    public void insert(int elementValue) {
        this.heap[heapSize] = elementValue;
        this.heapSize++;
        this.siftUp(this.heapSize - 1);
    }

    /**
     * time complexity O(1)
     */
    public Integer getMin() {
        if (this.isEmpty()) {
            return null;
        } else {
            return this.heap[0];
        }
    }

    /**
     * time complexity O(log n)
     */
    public Integer extractMin() {
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
        if (newValue < oldValue) {
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
