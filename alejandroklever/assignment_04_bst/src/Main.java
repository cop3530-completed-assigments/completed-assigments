public class Main {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        for (int key : keys) {
            bst.treeInsert(key);
        }

        System.out.println("--- Running BST Tests ---");
        
        testSearch(bst);
        testMinimum(bst, 20);
        testMaximum(bst, 80);
        
        System.out.println("\n--- All tests complete ---");
    }

  
    public static void testSearch(BinarySearchTree bst) {
        System.out.println("\n--- Testing Search ---");

        // A 2D array to hold test cases for search
        // Each inner array: {key to search, expected result (true if found)}
        Object[][] searchTestCases = {
            {40, true},   // Existing node
            {99, false},  // Non-existing node
            {50, true},   // Root node
            {80, true},   // Leaf node
            {10, false}   // Non-existing node
        };

        for (Object[] testCase : searchTestCases) {
            int key = (int) testCase[0];
            boolean expectedFound = (boolean) testCase[1];
            
            BinaryNode resultNode = bst.treeSearch(key);
            boolean actualFound = (resultNode != null);
            
            // Use the generic test function to check and print results
            runTest("Search for key " + key, expectedFound ? 1 : 0, actualFound ? 1 : 0);
        }
    }

    public static void testMinimum(BinarySearchTree bst, int expectedMin) {
        System.out.println("\n--- Testing Minimum ---");
        BinaryNode minNode = bst.treeMinimum();
        int actualMin = (minNode != null) ? minNode.key : -1; // Use -1 if tree is empty
        runTest("Find minimum key", expectedMin, actualMin);
    }

    public static void testMaximum(BinarySearchTree bst, int expectedMax) {
        System.out.println("\n--- Testing Maximum ---");
        BinaryNode maxNode = bst.treeMaximum();
        int actualMax = (maxNode != null) ? maxNode.key : -1; // Use -1 if tree is empty
        runTest("Find maximum key", expectedMax, actualMax);
    }

    public static void runTest(String testName, int expected, int actual) {
        System.out.println("Test: " + testName);
        System.out.println("  - Expected: " + expected);
        System.out.println("  - Actual:   " + actual);
        
        if (expected == actual) {
            System.out.println("  -> Result: PASSED");
        } else {
            System.out.println("  -> Result: FAILED");
        }
    }
}
