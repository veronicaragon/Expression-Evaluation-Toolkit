import java.util.Stack;

public class InfixToPostfix {

    // Function to check if a given character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Function to get the precedence of an operator
    private static int getPrecedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1; // Default case for parentheses
    }

    // Function to convert infix expression to postfix expression
    public static String infixToPostfixWithSteps(String infixExpression) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : infixExpression.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch); // Append operands to the result
                System.out.println("Operand: " + ch + ", Postfix: " + postfix.toString());
            } else if (ch == '(') {
                stack.push(ch); // Push open parenthesis onto the stack
            } else if (ch == ')') {
                // Pop and append operators from the stack until an open parenthesis is encountered
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Pop the open parenthesis
            } else if (isOperator(ch)) {
                // Pop and append operators from the stack with higher or equal precedence
                while (!stack.isEmpty() && getPrecedence(ch) <= getPrecedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch); // Push the current operator onto the stack
                System.out.println("Operator: " + ch + ", Postfix: " + postfix.toString());
            }
        }

        // Pop and append any remaining operators from the stack to the result
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String infixExpression = "5+3*(2+3*(4-3))";
        System.out.println("Steps of Infix to Postfix Conversion:");
        infixToPostfixWithSteps(infixExpression);
    }
}