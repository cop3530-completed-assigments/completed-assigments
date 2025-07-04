import java.util.Arrays;
import java.util.List;

public class TestCases {
    /**
     * Tests for Task1.findDominants method
     */
    public static void testTask1() {
        System.out.println("=== Testing Task1.findDominants ===");
        
        // Test case 1: Example from the Assignment
        testFindDominants(
            new int[]{16, 17, 4, 3, 5, 2},
            List.of(17, 5, 2),
            "Test case 1: Example from the Assignment"
        );
        
        // Test case 2: All elements in descending order
        testFindDominants(
            new int[]{10, 9, 8, 7, 6},
            List.of(10, 9, 8, 7, 6),
            "Test case 2: All elements in descending order"
        );
        
        // Test case 3: All elements in ascending order
        testFindDominants(
            new int[]{1, 2, 3, 4, 5},
                List.of(5),
            "Test case 3: All elements in ascending order"
        );
    }

    /**
     * Helper method to test Task1.findDominants
     */
    private static void testFindDominants(int[] input, List<Integer> expected, String testName) {
        System.out.println("\n" + testName);
        System.out.println("Input: " + Arrays.toString(input));
        
        List<Integer> result = Task1.findDominants(input);
        
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + result);
        
        boolean passed = result.equals(expected);
        System.out.println("Test " + (passed ? "PASSED" : "FAILED"));
    }

    /**
     * Tests for Task2.rearrange method
     */
    public static void testTask2() {
        System.out.println("\n=== Testing Task2.rearrange ===");
        
        // Test case 1: Example from the Assignment
        testRearrange(
            new int[]{1, -1, 3, 2, -7, -5, 11, 6},
            new int[]{-1, -7, -5, 1, 3, 2, 11, 6},
            "Test case 1: Example from the Assignment"
        );
        
        // Test case 2: All positive numbers
        testRearrange(
            new int[]{1, 2, 3, 4, 5},
            new int[]{1, 2, 3, 4, 5},
            "Test case 2: All positive numbers"
        );
        
        // Test case 3: All negative numbers
        testRearrange(
            new int[]{-1, -2, -3, -4, -5},
            new int[]{-1, -2, -3, -4, -5},
            "Test case 3: All negative numbers"
        );
    }

    /**
     * Helper method to test Task2.rearrange
     */
    private static void testRearrange(int[] input, int[] expected, String testName) {
        System.out.println("\n" + testName);
        System.out.println("Input: " + Arrays.toString(input));
        
        int[] result = Task2.rearrange(input);
        
        System.out.println("Expected result: " + Arrays.toString(expected));
        System.out.println("Actual result: " + Arrays.toString(result));
        
        boolean passed = Arrays.equals(result, expected);
        System.out.println("Test " + (passed ? "PASSED" : "FAILED"));
    }
}