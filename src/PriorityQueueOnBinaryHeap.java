public class PriorityQueueOnBinaryHeap extends BinaryMaxHeap {
    public PriorityQueueOnBinaryHeap(int capacity) {
        super(capacity);
    }

    public void insert(int priority) {
        super.insert(priority);
    }

    public Integer extractMaxPriorityElement() {
        return super.extractMax();
    }

    public void increase(int index, int factor) {
        super.updateByIndex(index, super.heap[index] + factor);
    }
}