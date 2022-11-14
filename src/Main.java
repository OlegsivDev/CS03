public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // testing BinaryHeap class
        BinaryHeap testHeap = new BinaryHeap(10);

        testHeap.insert(8);
        testHeap.insert(3);
        testHeap.insert(2);
        testHeap.insert(5);
        testHeap.insert(6);
        testHeap.updateByIndex(0, 1);
        testHeap.updateByValue(5, 20);
        System.out.println(testHeap.extractMin());
        System.out.println(testHeap.extractMin());
        System.out.println(testHeap.extractMin());

        //testing PriorityQueue on binaryHeap
        PriorityQueueOnBinaryHeap testQueue = new PriorityQueueOnBinaryHeap(10);
        testQueue.insert(5);
        testQueue.insert(2);
        testQueue.insert(3);
        testQueue.insert(10);
        testQueue.insert(6);
        System.out.println(testQueue.extractMaxPriorityElement());
        testQueue.increase(1, 200);
    }
}