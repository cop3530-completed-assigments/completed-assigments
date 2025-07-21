import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        testIntegerMergeSort();
        testAnyTypeMergeSortWithStudents();
        testAnyTypeMergeSortWithIntegers();
        testAnyTypeMergeSortWithStrings();
    }

    public static void testIntegerMergeSort() {
        System.out.println("--- Testing IntegerMergeSort ---");
        int[] arr = {12, 11, 13, 5, 6, 7};
        int[] expected = {5, 6, 7, 11, 12, 13};
        
        System.out.println("Original array: " + arrayToString(arr));
        IntegerMergeSort.mergeSort(arr);
        System.out.println("Sorted array:   " + arrayToString(arr));
        System.out.println("Expected array: " + arrayToString(expected));
        
        boolean passed = Arrays.equals(arr, expected);
        System.out.println("Test passed: " + passed);
        System.out.println();
    }

    public static void testAnyTypeMergeSortWithStudents() {
        System.out.println("--- Testing AnyTypeMergeSort with Student objects ---");
        Student[] students = {
            new Student("Alice", 3.8),
            new Student("Bob", 3.5),
            new Student("Charlie", 4.0),
            new Student("David", 3.2)
        };
        
        Student[] expected = {
            new Student("David", 3.2),
            new Student("Bob", 3.5),
            new Student("Alice", 3.8),
            new Student("Charlie", 4.0)
        };

        System.out.println("Original array: " + arrayToString(students));
        AnyTypeMergeSort.mergeSort(students);
        System.out.println("Sorted array:   " + arrayToString(students));
        System.out.println("Expected array: " + arrayToString(expected));

        boolean passed = Arrays.equals(students, expected);
        System.out.println("Test passed: " + passed);
        System.out.println();
    }

    public static void testAnyTypeMergeSortWithIntegers() {
        System.out.println("--- Testing AnyTypeMergeSort with Integer objects  ---");
        Integer[] arr = {12, 11, 13, 5, 6, 7};
        Integer[] expected = {5, 6, 7, 11, 12, 13};

        System.out.println("Original array: " + arrayToString(arr));
        AnyTypeMergeSort.mergeSort(arr);
        System.out.println("Sorted array:   " + arrayToString(arr));
        System.out.println("Expected array: " + arrayToString(expected));

        boolean passed = Arrays.equals(arr, expected);
        System.out.println("Test passed: " + passed);
        System.out.println();
    }

    public static void testAnyTypeMergeSortWithStrings() {
        System.out.println("--- Testing AnyTypeMergeSort with String objects ---");
        String[] arr = {"banana", "apple", "cherry", "date"};
        String[] expected = {"apple", "banana", "cherry", "date"};

        System.out.println("Original array: " + arrayToString(arr));
        AnyTypeMergeSort.mergeSort(arr);
        System.out.println("Sorted array:   " + arrayToString(arr));
        System.out.println("Expected array: " + arrayToString(expected));

        boolean passed = Arrays.equals(arr, expected);
        System.out.println("Test passed: " + passed);
        System.out.println();
    }

    public static String arrayToString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static <T> String arrayToString(T[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < arr.length; i++) {
            stringBuilder.append(arr[i]);
            if (i < arr.length - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

