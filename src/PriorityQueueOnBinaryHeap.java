public class PriorityQueueOnBinaryHeap extends BinaryMaxHeap {
    public PriorityQueueOnBinaryHeap(int capacity) {
        super(capacity);
    }

    /**
     * time complexity O(log n)
     */
    public void insert(int priority) {
        super.insert(priority);
    }

    /**
     * time complexity O(log n)
     */
    public Integer extractMaxPriorityElement() {
        return super.extractMax();
    }

    /**
     * time complexity O(log n)
     */
    public void increase(int index, int factor) {
        super.updateByIndex(index, super.heap[index] + factor);
    }
}