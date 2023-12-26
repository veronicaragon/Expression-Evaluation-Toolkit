import java.util.Stack;

public class BalancedParentheses {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else {
                return false; // Unbalanced parentheses
            }
        }
        return stack.isEmpty(); // Parentheses are balanced if the stack is empty
    }

    public static void main(String[] args) {
        String expression1 = "()";
        String expression2 = "((()))";
        String expression3 = "({[]})";
        String expression4 = "(()";
        String expression5 = "([)]";

        System.out.println("Expression 1 is balanced: " + isBalanced(expression1)); // true
        System.out.println("Expression 2 is balanced: " + isBalanced(expression2)); // true
        System.out.println("Expression 3 is balanced: " + isBalanced(expression3)); // true
        System.out.println("Expression 4 is balanced: " + isBalanced(expression4)); // false
        System.out.println("Expression 5 is balanced: " + isBalanced(expression5)); // false
    }
}
/*
Notes:
`push` and `pop` are fundamental operations associated with stacks, which are a common data structure used in computer science and programming. 
Stacks are based on the Last-In-First-Out (LIFO) principle, meaning that the last element added to the stack is the first one to be removed.

Here's an explanation of these two operations:

1. `push`: The `push` operation is used to add an element onto the top of the stack. When you push an element onto the stack, 
   it becomes the new top element, and the stack grows in size. In Java, you can use the `push` method in the `Stack` class 
   (or `add` method in some other implementations) to add an element to the stack.

   Example in Java:

   Stack<Integer> stack = new Stack<>();
   stack.push(10); // Push 10 onto the stack
   stack.push(20); // Push 20 onto the stack
   stack.push(30); // Push 30 onto the stack
   // The stack now contains [10, 20, 30] with 30 as the top element.


2. `pop`: The `pop` operation is used to remove and return the top element from the stack. When you pop an element, it is removed from the stack, 
    and the next element beneath it becomes the new top element. In Java, you can use the `pop` method in the `Stack` class to remove and return the top element.

   Example in Java:

   Stack<Integer> stack = new Stack<>();
   stack.push(10);
   stack.push(20);
   stack.push(30);
   int topElement = stack.pop(); // Removes and returns 30
   // The stack now contains [10, 20] with 20 as the new top element.


The stack operations `push` and `pop` are often used for managing elements in a last-in, first-out manner. Stacks are versatile and used in various applications, 
including parsing expressions, tracking function calls in a program, and solving problems like the balanced parentheses problem mentioned earlier.


In Java, the `toCharArray()` method is a built-in method provided by the `String` class. 
When called on a string, it returns an array of characters representing the characters of the string.

Here's how you can use it:

String str = "Hello, World!";
char[] charArray = str.toCharArray();

In this example, `toCharArray()` is called on the string `"Hello, World!"`, and it returns a character array 
`['H', 'e', 'l', 'l', 'o', ',', ' ', 'W', 'o', 'r', 'l', 'd', '!']`.

This method is useful when you need to manipulate individual characters of a string, as characters in a char array can be accessed by their index. 
For example, `charArray[0]` would give you the first character `'H'`, `charArray[1]` would give you `'e'`, and so on.
 */