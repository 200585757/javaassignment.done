import java.util.ArrayList;

public class New {
    public static void main(String[] args) {
        int[] sizes = { 1000, 10000, 100000, 1000000 };
        for (int size : sizes) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                arrayList.add(i);
            } 

            System.out.println("Size: " + size);

            // Read by Index
            long startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                arrayList.get(i);
            }
            long endTime = System.nanoTime();
            System.out.println("Read by Index: " + (endTime - startTime) + " ns");

            // Read by Value
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                arrayList.contains(i);
            }
            endTime = System.nanoTime();
            System.out.println("Read by Value: " + (endTime - startTime) + " ns");

            // Insert in Head
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                arrayList.add(0, i);
            }
            endTime = System.nanoTime();
            System.out.println("Insert in Head: " + (endTime - startTime) + " ns");

            // Insert in Mid
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                arrayList.add(size / 2, i);
            }
            endTime = System.nanoTime();
            System.out.println("Insert in Mid: " + (endTime - startTime) + " ns");

            // Insert in Tail
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                arrayList.add(i);
            }
            endTime = System.nanoTime();
            System.out.println("Insert in Tail: " + (endTime - startTime) + " ns");

            // Delete from Head
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                arrayList.remove(0);
            }
            endTime = System.nanoTime();
            System.out.println("Delete from Head: " + (endTime - startTime) + " ns");

            // Delete from Mid
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                arrayList.remove(size / 2);
            }
            endTime = System.nanoTime();
            System.out.println("Delete from Mid: " + (endTime - startTime) + " ns");

            // Delete from Tail
            startTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                arrayList.remove(arrayList.size() - 1);
            }
            endTime = System.nanoTime();
            System.out.println("Delete from Tail: " + (endTime - startTime) + " ns");

            System.out.println();
        }
    }
}