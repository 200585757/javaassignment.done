import java.util.HashSet;
import java.util.Set;

// 2
public class HashSetPerformanceTest {
    public static void main(String[] args) {
        int[] sizes = { 1000, 10000, 100000, 1000000 };
        for (int size : sizes) {
            Set<Integer> hashSet = new HashSet<>();
            for (int i = 0; i < size; i++) {
                hashSet.add(i);
            }

            // Read by Value
            long startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                hashSet.contains(i);
            }
            long endTime = System.nanoTime();
            System.out.println("Read by Value for size " + size + ": " + (endTime - startTime) + " ns");

            // Insert in Head (not applicable for HashSet)
            System.out.println("Insert in Head for size " + size + ": N/A");

            // Insert in Mid (not applicable for HashSet)
            System.out.println("Insert in Mid for size " + size + ": N/A");

            // Insert in the tale
            startTime = System.nanoTime();
            hashSet.add(size);
            endTime = System.nanoTime();
            System.out.println("Insert in the tale for size " + size + ": " + (endTime - startTime) + " ns");

            // Delete from Head (not applicable for HashSet)
            System.out.println("Delete from Head for size " + size + ": N/A");

            // Delete from Mid (not applicable for HashSet)
            System.out.println("Delete from Mid for size " + size + ": N/A");

            // Delete from Tale
            startTime = System.nanoTime();
            hashSet.remove(size);
            endTime = System.nanoTime();
            System.out.println("Delete from Tale for size " + size + ": " + (endTime - startTime) + " ns");
        }
    }
}