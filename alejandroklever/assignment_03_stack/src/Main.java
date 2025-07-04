import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<TestCase> testCases = List.of(
                new TestCase("3 + 4 * 2 / ( 1 - 5 )", "3 4 2 * 1 5 - / +"),
                new TestCase("10 + 2 * 6", "10 2 6 * +"),
                new TestCase("100 * ( 2 + 12 ) / 14", "100 2 12 + * 14 /"),
                new TestCase("5 + ( ( 1 + 2 ) * 4 ) - 3", "5 1 2 + 4 * + 3 -"),
                new TestCase("7 + 8 * ( 3 + 2 )", "7 8 3 2 + * +"),
                new TestCase("42", "42"),
                new TestCase("( 3 + 4 ) * 5 - 6", "3 4 + 5 * 6 -"),
                new TestCase("20 + 3 * 4 - 6 / 2", "20 3 4 * + 6 2 / -")
        );

        for (TestCase test : testCases) {
            try {
                String result = PostfixNotation.convert(test.infix).trim();
                boolean passed = result.equals(test.expected);
                System.out.printf("Infix: %-35s | Expected: %-30s | Result: %-30s | %s\n",
                        test.infix, test.expected, result, passed ? "PASS" : "FAIL");
            } catch (Exception e) {
                System.out.printf("Infix: %-35s | ERROR: %s\n", test.infix, e.getMessage());
            }
        }
    }

    // Helper class to hold test cases
    static class TestCase {
        String infix;
        String expected;

        TestCase(String infix, String expected) {
            this.infix = infix;
            this.expected = expected;
        }
    }
}


