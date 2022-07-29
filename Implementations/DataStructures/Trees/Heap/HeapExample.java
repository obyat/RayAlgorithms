package DataStructures.Trees.Heap;

public class HeapExample {
    public static void main(String[] args) {

        System.out.println("MaxHeap:");
        MaxHeap<Integer> maxHeap = new MaxHeap<Integer>();
        maxHeap.insertAll(new Integer[] {30, 20, 18, 8, 10, 12, 14});
        System.out.println("root/max element: " + maxHeap.getRoot());
        System.out.println("Sorting MaxHeap... ");
        maxHeap.sort();
        
        System.out.println();

        System.out.println("MinHeap:");
        MinHeap<Integer> minHeap = new MinHeap<Integer>();
        minHeap.insertAll(new Integer[] {30, 20, 18, 8, 10, 12, 14});
        System.out.println("root/min element: " + minHeap.getRoot());
        System.out.println("Sorting MinHeap... ");
        minHeap.sort();

    }
}
