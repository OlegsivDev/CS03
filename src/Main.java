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

        System.out.println(testHeap.getMin());
    }
}