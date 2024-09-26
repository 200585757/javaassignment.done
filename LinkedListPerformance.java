import java.util.LinkedList;
import java.util.List;

//4
public class LinkedListPerformance {

    // Helper function to measure execution time
    public static long measureTime(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        return endTime - startTime; // time in nanoseconds
    }

    // Test LinkedList for various operations
    public static void testLinkedList(int size) {
        List<Integer> list = new LinkedList<>();
        // Insert elements at tail
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        int midIndex = size / 2;

        // Read by Index
        long readIndexTime = measureTime(() -> {
            int val = list.get(midIndex);
        });

        // Read by Value
        long readValueTime = measureTime(() -> {
            boolean found = list.contains(midIndex);
        });

        // Insert at Head
        long insertHeadTime = measureTime(() -> {
            list.add(0, -1);
        });

        // Insert at Mid
        long insertMidTime = measureTime(() -> {
            list.add(midIndex, -1);
        });

        // Insert at Tail
        long insertTailTime = measureTime(() -> {
            list.add(-1);
        });

        // Delete from Head
        long deleteHeadTime = measureTime(() -> {
            list.remove(0);
        });

        // Delete from Mid
        long deleteMidTime = measureTime(() -> {
            list.remove(midIndex);
        });

        // Delete from Tail
        long deleteTailTime = measureTime(() -> {
            list.remove(list.size() - 1);
        });

        System.out.println("Results for LinkedList of size " + size + ":");
        System.out.println("Read by Index: " + readIndexTime + " ns");
        System.out.println("Read by Value: " + readValueTime + " ns");
        System.out.println("Insert at Head: " + insertHeadTime + " ns");
        System.out.println("Insert at Mid: " + insertMidTime + " ns");
        System.out.println("Insert at Tail: " + insertTailTime + " ns");
        System.out.println("Delete from Head: " + deleteHeadTime + " ns");
        System.out.println("Delete from Mid: " + deleteMidTime + " ns");
        System.out.println("Delete from Tail: " + deleteTailTime + " ns");
    }

    public static void main(String[] args) {
        // Test for different sizes
        int[] sizes = { 1000, 10000, 100000, 1000000 };

        for (int size : sizes) {
            System.out.println("\nTesting LinkedList of size " + size + "...");
            testLinkedList(size);
        }
    }
}