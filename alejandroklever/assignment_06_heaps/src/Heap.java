public class Heap {
    public static int[] maxHeapify(int[] A, int i) {
        return heapify(A, i, A.length - 1, true);
    }
    
    public static int[] buildMaxHeap(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 1; i--)
            maxHeapify(A, i);
        return A;
    }

    public static int[] minHeapify(int[] A, int i) {
        return heapify(A, i, A.length - 1, false);
    }

    public static int[] buildMinHeap(int[] A) {
        for (int i = (A.length - 1) / 2; i >= 1; i--)
            minHeapify(A, i);
        return A;
    }
    
    private static int[] heapify(int[] A, int i, int heapSize, boolean isMaxHeap) {
        int left = 2 * i;
        int right = (2 * i) + 1;
        int target = i;
        
        if (left <= heapSize) {
            if (isMaxHeap ? A[left] > A[target] : A[left] < A[target])
                target = left;
        }
        
        if (right <= heapSize) {
            if (isMaxHeap ? A[right] > A[target] : A[right] < A[target])
                target = right;
        }
        
        if (target != i) {
            int temp = A[target];
            A[target] = A[i];
            A[i] = temp;
            heapify(A, target, heapSize, isMaxHeap);
        }
        
        return A;
    }
    
    public static int[] heapSort(int[] A) {
        buildMaxHeap(A);
        int heapSize = A.length - 1;
        
        for (int i = A.length - 1; i >= 2; i--) {
            int temp = A[1];
            A[1] = A[i];
            A[i] = temp;
            heapSize--;
            heapify(A, 1, heapSize, true);
        }
        
        return A;
    }
}
