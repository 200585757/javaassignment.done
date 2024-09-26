import java.util.ArrayList;
import java.util.Random;

//1 
public class ArrayPerformanceTest {

    // Function to measure the time taken for a given operation
    public static long measureTime(Runnable operation) {
        long startTime = System.nanoTime();
        operation.run();
        return System.nanoTime() - startTime;
    }

    public static void main(String[] args) {
        // Define the array sizes
        int[] sizes = { 1000, 10000, 100000, 1000000 };

        // Random number generator for values
        Random random = new Random();

        // Perform operations for each size
        for (int size : sizes) {
            System.out.println("Array Size: " + size);
            ArrayList<Integer> array = new ArrayList<>(size);

            // Fill the array with random values
            for (int i = 0; i < size; i++) {
                array.add(random.nextInt());
            }

            // 1. Read by index (middle index)
            long timeReadByIndex = measureTime(() -> {
                int value = array.get(size / 2); // Read from the middle index
            });
            System.out.println("Read by Index: " + timeReadByIndex + " ns");

            // 2. Read by value
            long timeReadByValue = measureTime(() -> {
                boolean found = array.contains(array.get(size / 2)); // Find value from the middle index
            });
            System.out.println("Read by Value: " + timeReadByValue + " ns");

            // 3. Insert at Head
            long timeInsertHead = measureTime(() -> {
                array.add(0, random.nextInt()); // Insert at head
            });
            System.out.println("Insert at Head: " + timeInsertHead + " ns");

            // 4. Insert in Middle
            long timeInsertMid = measureTime(() -> {
                array.add(size / 2, random.nextInt()); // Insert at middle
            });
            System.out.println("Insert in Middle: " + timeInsertMid + " ns");

            // 5. Insert at Tail
            long timeInsertTail = measureTime(() -> {
                array.add(random.nextInt()); // Insert at tail
            });
            System.out.println("Insert at Tail: " + timeInsertTail + " ns");

            // 6. Delete from Head
            long timeDeleteHead = measureTime(() -> {
                array.remove(0); // Remove from head
            });
            System.out.println("Delete from Head: " + timeDeleteHead + " ns");

            // 7. Delete from Middle
            long timeDeleteMid = measureTime(() -> {
                array.remove(size / 2); // Remove from middle
            });
            System.out.println("Delete from Middle: " + timeDeleteMid + " ns");

            // 8. Delete from Tail
            long timeDeleteTail = measureTime(() -> {
                array.remove(array.size() - 1); // Remove from tail
            });
            System.out.println("Delete from Tail: " + timeDeleteTail + " ns");

            System.out.println("------------------------------------------------");
        }
    }
}