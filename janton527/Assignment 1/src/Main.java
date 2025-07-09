import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // TASK 1
        int[] integers = {16,17,4,3,5,2};
        int max = 0;
        ArrayList<Integer> dominantElements = new ArrayList<>();

        for (int i = integers.length-1; i >= 0; i--){
            if (integers[i] > max){
                dominantElements.add(0, integers[i]);
                max = integers[i];
            }
        }

        System.out.println("TASK 1");
        System.out.println(dominantElements.toString());
        System.out.println();

        //TASK 2
        int arr[] = {1,-1,3,2,-7,-5,11,6};
        int[] result = sort(arr);

        System.out.println("TASK 2");
        System.out.println(Arrays.toString(result));
        System.out.println();
    }

    public static int[] sort(int[] arr) {
        return sortNegative(arr, 0, new int[arr.length], 0);
    }

    private static int[] sortNegative(int[] arr, int index, int[] result, int resIndex) {
        if (index == arr.length) {
            // Second pass: append positives
            return appendPositives(arr, 0, result, resIndex);
        }

        //find the next negative number and assign it to the next element in result
        if (arr[index] <= 0) {
            result[resIndex++] = arr[index];
        }

        return sortNegative(arr, index + 1, result, resIndex);
    }

    private static int[] appendPositives(int[] arr, int index, int[] result, int resIndex) {
        if (index == arr.length) {
            return result;
        }

        //find the next positive element and assign it to the next element in result
        if (arr[index] > 0) {
            result[resIndex++] = arr[index];
        }

        return appendPositives(arr, index + 1, result, resIndex);
    }
}