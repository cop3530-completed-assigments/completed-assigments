public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 1; i < arr.length; i++)
            arr[i] = (int) (Math.random() * 100);
        
        System.out.println("Before Heapifying");
        
        for (int i = 1; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        int[] maxHeap = Heap.buildMaxHeap(arr.clone());
        System.out.println();
        System.out.println("After Max Heapifying");
        for (int j : maxHeap) System.out.print(j + " ");


        int[] minHeap = Heap.buildMinHeap(arr.clone());
        System.out.println();
        System.out.println("After Min Heapifying");
        for (int j : minHeap) System.out.print(j + " ");

        int[] sorted = Heap.heapSort(arr.clone());
        System.out.println();
        System.out.println("Sorted Array");
        for (int j: sorted) System.out.print(j + " ");
    }
}

