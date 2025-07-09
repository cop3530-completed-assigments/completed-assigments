import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        String input;
        Stack<Character> operators = new Stack<>();

        //get input from the user
        System.out.println("Enter a mathematical expression in Infix Notation: ");
        input = keyboard.nextLine();


        for (char c : input.toCharArray()){
            if (Character.isLetterOrDigit(c)){      //output operands
                System.out.print(c);
            } else if (c == '('){                   //push ( to stack
                operators.push(c);
            } else if (c == ')'){                   //pop operantors to output until ( is Top of Stack
                while (!operators.isEmpty() && operators.peek() != '('){
                    System.out.print(operators.pop());
                }
                operators.pop();                    //pop (
            } else {
                //if an operator is read and it's priority is less than the operator @ top of stack,
                // pop until operator of lower value is found
                while (!operators.isEmpty() && getPrio(c) <= getPrio(operators.peek())){
                    System.out.print(operators.pop());
                }

                operators.push(c);
            }
        }

        //pop remaining operantors once all of input has been processed
        while (!operators.isEmpty()){
            System.out.print(operators.pop());
        }
    }

    //returns the priority value for each of the operators
    public static int getPrio(char c) {
        if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
}