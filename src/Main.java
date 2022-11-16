public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // testing BinaryHeap class
//        BinaryMaxHeap testHeap = new BinaryMaxHeap(2);
//
//        testHeap.insert(8);
//        testHeap.insert(3);
//        testHeap.insert(2);
//        testHeap.insert(5);
//        testHeap.insert(6);
//        testHeap.updateByIndex(0, 1);
//        testHeap.updateByValue(5, 20);
//        System.out.println(testHeap.extractMax());
//        System.out.println(testHeap.extractMax());
//        System.out.println(testHeap.extractMax());
//
//        //testing PriorityQueue on binaryHeap
//        PriorityQueueOnBinaryHeap testQueue = new PriorityQueueOnBinaryHeap(10);
//        testQueue.insert(5);
//        testQueue.insert(2);
//        testQueue.insert(3);
//        testQueue.insert(10);
//        testQueue.insert(6);
//        System.out.println(testQueue.extractMaxPriorityElement());
//        testQueue.increase(1, 200);

//        PriorityArray testArr = new PriorityArray(5);
//        testArr.insert(5);
//        testArr.insert(6);
//        testArr.insert(1);
//        testArr.insert(8);
//        testArr.insert(15);
//        testArr.updatePriorityByIndex(0,50);
//        testArr.increasePriorityByIndex(1, 150);
//        testArr.increasePriorityByValue(1, 423);
//        System.out.println(testArr.extractMax());

        PriorityList testList = new PriorityList();

        testList.insert(6);
        testList.insert(4);
        testList.insert(9);
        testList.insert(2);
        testList.insert(8);
        testList.insert(3);
        testList.increasePriorityByIndex(2, 100);
        testList.increasePriorityByValue(4,150);
        testList.extractMax();
        testList.extractMax();
        testList.extractMax();
    }
}