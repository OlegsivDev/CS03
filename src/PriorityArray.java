import java.util.Arrays;
import java.util.Collections;

public class PriorityArray {
    protected int[] queue;
    private int queueSize;
    private final int queueCapacity;
    private int minValue;

    public PriorityArray(int capacity) {
        this.queueCapacity = capacity;
        this.queueSize = 0;
        queue = new int[capacity];
        Arrays.fill(queue, -1);
    }

    private boolean isEmpty() {
        return queueSize == 0;
    }

    private boolean isFull() {
        return queueSize == queueCapacity;
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalArgumentException("Can't insert element, PriorityArray already full");
        } else if (isEmpty()) {
            this.queue[0] = value;
            this.queueSize++;
            this.minValue = value;
        } else if (value < minValue) {
            this.queue[queueSize] = value;
            this.queueSize++;
            return;
        } else {
            int moveFromIndex = 0;
            for (int i = 0; i < this.queueSize; i++) {
                if (value >= this.queue[i]) {
                    moveFromIndex = i;
                    break;
                }
            }
            int[] copiedArray = Arrays.copyOfRange(this.queue, moveFromIndex, queueSize);
            this.queue[moveFromIndex] = value;
            int moveIndex = moveFromIndex + 1;
            for (int copyElementValue : copiedArray) {
                this.queue[moveIndex] = copyElementValue;
                moveIndex++;
            }
            this.queueSize++;
            if (value < this.minValue) {
                this.minValue = value;
            }
        }
    }
    public void updatePriorityByIndex(int index, int newPriority) {
        this.queue[index] = newPriority;
        Arrays.sort(this.queue);
        int[] copiedArray = Arrays.copyOf(queue, queueCapacity);
        for (int i = this.queueCapacity-1, g = 0; i >= 0; i--, g++) {
            this.queue[g] = copiedArray[i];
        }
    }
    public void increasePriorityByIndex(int index, int factor) {
        int oldPriority = this.queue[index];
        this.updatePriorityByIndex(index, oldPriority + factor);
    }

    public void increasePriorityByValue(int oldValue, int factor) {
        int valueIndex = 0;
        for (int val : this.queue) {
            if (val == oldValue) {
                break;
            }
            valueIndex++;
        }
        this.increasePriorityByIndex(valueIndex, factor);
    }
}
