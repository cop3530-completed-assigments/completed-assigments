import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        TestCases.testTask1();
        TestCases.testTask2();
    }
}

/**
 * Class that provides a solution for finding dominant elements in an array.
 * A dominant element is defined as an element that is greater than all elements to its right.
 */
class Task1 {
    /**
     * Finds all dominant elements in an array.
     *
     * @param nums The input array to find dominant elements in
     * @return A list containing all dominant elements, in the order from right to left
     */
    static List<Integer> findDominants(int[] nums) {
        if (nums.length == 0) return List.of();

        List<Integer> dominants = new ArrayList<>();
        dominants.add(nums[nums.length - 1]);

        for (int i = nums.length - 2; i >= 0; i--) {
            int currentNumber = nums[i];

            if (currentNumber > dominants.getLast()) {
                dominants.add(currentNumber);
            }
        }

        return dominants.reversed();
    }
}

/**
 * Class that provides a solution for rearranging array elements
 * by placing all negative numbers before positive numbers.
 */
class Task2 {
    /**
     * Rearranges the input array by placing all negative numbers before positive numbers
     * while maintaining their relative order.
     *
     * @param nums The input array to be rearranged
     * @return A new array with negative numbers followed by positive numbers
     */
    static int[] rearrange(int[] nums) {
        int[] rearranged = new int[nums.length];

        int lastIndex = rearrange(nums, 0, rearranged, 0, true);
        rearrange(nums, 0, rearranged, lastIndex, false);

        return rearranged;
    }

    /**
     * Helper recursive method to perform the array rearrangement.
     *
     * @param nums               The original input array
     * @param i                  Current index in the input array
     * @param arr                The output array being filled
     * @param j                  Current index in the output array
     * @param rearrangeNegatives Flag to indicate whether we're processing negative numbers (true) or non-negative numbers (false)
     * @return The next available index in the output array
     */
    private static int rearrange(int[] nums, int i, int[] arr, int j, boolean rearrangeNegatives) {
        if (i == nums.length) return j;

        if (rearrangeNegatives && nums[i] < 0) {
            arr[j++] = nums[i];
        } else if (!rearrangeNegatives && nums[i] >= 0) {
            arr[j++] = nums[i];
        }

        return rearrange(nums, i + 1, arr, j, rearrangeNegatives);
    }
}