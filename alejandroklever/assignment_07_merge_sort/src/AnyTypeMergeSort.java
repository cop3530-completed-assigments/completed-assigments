import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class AnyTypeMergeSort {
    public static <T extends Comparable<? super T>>void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<? super T>>void mergeSort(T[] arr, int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            return;
        }

        int midPoint = (upperBound + lowerBound) / 2;
        mergeSort(arr, lowerBound, midPoint);
        mergeSort(arr, midPoint + 1, upperBound);
        merge(arr, lowerBound, midPoint, upperBound);
    }

    private static <T extends Comparable<? super T>>  void merge(T[] arr, int lowerBound, int midPoint, int upperBound) {
        int nLeft = midPoint - lowerBound + 1;
        int nRight = upperBound - midPoint;
        
        T[] left = Arrays.copyOf(arr, nLeft);
        T[] right = Arrays.copyOf(arr, nRight);

        System.arraycopy(arr, lowerBound, left, 0, nLeft);
        System.arraycopy(arr, midPoint + 1, right, 0, nRight);

        int i = 0, j = 0, k = lowerBound;

        while (i < nLeft && j < nRight) {
            if (left[i].compareTo(right[j]) <= 0) {
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
