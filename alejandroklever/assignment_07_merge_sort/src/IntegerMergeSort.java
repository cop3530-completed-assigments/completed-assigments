public class IntegerMergeSort {
    public static void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            return;
        }

        int midPoint = (upperBound + lowerBound) / 2;
        mergeSort(arr, lowerBound, midPoint);
        mergeSort(arr, midPoint + 1, upperBound);
        merge(arr, lowerBound, midPoint, upperBound);
    }

    private static void merge(int[] arr, int lowerBound, int midPoint, int upperBound) {
        int nLeft = midPoint - lowerBound + 1;
        int nRight = upperBound - midPoint;

        int[] left = new int[nLeft];
        int[] right = new int[nRight];

        System.arraycopy(arr, lowerBound, left, 0, nLeft);
        System.arraycopy(arr, midPoint + 1, right, 0, nRight);

        int i = 0, j = 0, k = lowerBound;

        while (i < nLeft && j < nRight) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < nLeft) {
            arr[k++] = left[i++];
        }

        while (j < nRight) {
            arr[k++] = right[j++];
        }
    }
}

