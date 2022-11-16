import java.util.LinkedList;

public class PriorityList {
    protected LinkedList<Integer> queue = new LinkedList<Integer>();

    /**
     * time complexity O(1)
     */
    public void insert(Integer value) {
        queue.add(value);
    }

    /**
     * time complexity O(n) due to linear search
     */
    public Integer extractMax() {
        if (queue.size() == 0) {
            throw new IllegalArgumentException("Can't extract any element from empty linked list ");
        } else {
            Integer maxValueIndex = 0;
            Integer maxValue = queue.get(0);
            for (int i = 0; i < queue.size(); i++) {
                if (queue.get(i) > maxValue) {
                    maxValue = queue.get(i);
                    maxValueIndex = i;
                }
            }
            Integer result = queue.get(maxValueIndex);
            this.queue.remove((int) maxValueIndex);
            return result;
        }
    }

    /**
     * time complexity O(n)
     */
    private void updateValueByIndex(Integer index, Integer newValue) {
        this.queue.set(index, newValue);
    }

    /**
     * time complexity O(n)
     */
    public void increasePriorityByIndex(Integer index, Integer factor) {
        Integer oldPriority = this.queue.get(index);
        this.updateValueByIndex(index, oldPriority + factor);
    }

    /**
     * time complexity O(n)
     */
    public void increasePriorityByValue(Integer valueToFind, Integer factor) {
        Integer index = queue.indexOf(valueToFind);
        increasePriorityByIndex(index, factor);
    }
}
