public class PostfixNotation {
    public static String convert(String infix) {
        Stack<String> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        String[] tokens = infix.trim().split("\\s+"); // Split by spaces

        for (String token : tokens) {
            if (isOperand(token)) {
                postfix.append(token).append(" ");
            } else if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty() && stack.peek().equals("(")) {
                    stack.pop(); // Discard "("
                } else {
                    throw new IllegalArgumentException("Mismatched parentheses");
                }
            } else { // Operator
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            String op = stack.pop();
            if (op.equals("(")) {
                throw new IllegalArgumentException("Mismatched parentheses");
            }
            postfix.append(op).append(" ");
        }

        return postfix.toString();
    }

    // Check if character is operand
    private static boolean isOperand(String s) {
        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    // Operator precedence
    private static int precedence(String op) {
        return switch (op) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            case "(" -> 0;  // '(' has lowest precedence when comparing
            default -> -1;
        };
    }
}
