import java.util.HashSet;

public class Main {
    private static final int[] testData = new int[]{25, 25, 40, 40, 100, 256, 316, 2025, 320394};

    public static void main(String[] args) {
        System.out.println("|------ Linear Prob Index ------|");
        HashMap hashMap1 = new HashMap(HashType.linear);
        testHashMap(hashMap1);

        System.out.println();
        System.out.println("|------ Quadratic Prob Index ------|");
        HashMap hashMap2 = new HashMap(HashType.quadratic);
        testHashMap(hashMap2);

        System.out.println();
        System.out.println("|------ Double Hash ------|");
        HashMap hashMap3 = new HashMap(HashType.doubleHash);
        testHashMap(hashMap3);
    }

    private static void testHashMap(HashMap hashMap) {
        // We are going to compare the behavior of our HashMap with a java HashSet
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i : testData) {
            hashMap.hashInsert(i);
            hashSet.add(i);
        }

        // Print our custom HashMap
        System.out.println("HashMap content: " + hashMap + "\n");

        // Compare sizes of the Java HashSet against our custom HashMap
        testHashMapHasTheRightSize(hashMap, hashSet);

        // Check if every item in the Java HashSet is contained on our custom HashMap
        testHashMapContainsTheCorrectElements(hashMap, hashSet);

        testCollisionHandling(hashMap);
    }

    private static void testHashMapHasTheRightSize(HashMap hashMap, HashSet<Integer> hashSet) {
        String testName = "Test HashMap has the right size";
        int expected = hashSet.size();
        int result = hashMap.size();
        System.out.println(new TestCase(testName, expected, result));
    }

    private static void testHashMapContainsTheCorrectElements(HashMap hashMap, HashSet<Integer> hashSet) {
        String testName = "Test HashMap contains only the right elements";
        boolean expected = true;
        boolean result = hashMap.size() == hashSet.size() && hashSet.stream().allMatch(hashMap::contains);
        System.out.println(new TestCase(testName, expected, result));
    }

    private static void testCollisionHandling(HashMap hashMap) {
        // Create values that will definitely collide
        int value1 = 5;
        int value2 = 5 + hashMap.capacity(); // Will hash to same slot
        
        hashMap.hashInsert(value1);
        hashMap.hashInsert(value2);
        
        String testName = "Test collision handling";
        boolean expected = true;
        boolean result = hashMap.contains(value1) && hashMap.contains(value2);

        System.out.println(new TestCase(testName, expected, result));
    }
}

class TestCase {
    public String testName;
    public Object expected;
    public Object result;

    public TestCase(String testName, Object expected, Object result) {
        this.testName = testName;
        this.expected = expected;
        this.result = result;
    }

    @Override
    public String toString() {
        return testName + "\n\tExpected: " + expected + "\n\tResult: " + result + "\n\t" + (result == expected ? "PASSED" : "FAILED");
    }
}
