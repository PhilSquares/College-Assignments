import java.util.Stack;

public class IntegerStack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.add(10);
        stack.add(20); //20 is at the top of the stack. 
        stack.add(1, 100); // We can add at a position.

        // Loop over int values.
        for (int value : stack) {
            System.out.println(value);
        }
    }
}