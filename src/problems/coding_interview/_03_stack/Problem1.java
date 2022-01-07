package problems.coding_interview._03_stack;

import java.util.ArrayList;
import java.util.Stack;

public class Problem1 {

    // Stack 뒤집기
    private Stack<Integer> reverseStack(Stack stack) {
        Stack<Integer> newStack = new Stack<>();
        while (!stack.empty()) {
            newStack.push((Integer) stack.pop());
        }
        return newStack;
    }

    private void insertAtBottom(Stack<Integer> stack, int number) {
        if (stack.empty()) {
            stack.push(number);
            return;
        }
        int temp = stack.pop();
        insertAtBottom(stack, number);
        stack.push(temp);

    }

    private Stack<Integer> reverseStackRecursive(Stack<Integer> stack) {
        if(stack.empty()) return stack;
        int temp = stack.pop();
        stack = reverseStack(stack);
        insertAtBottom(stack, temp);
        return stack;
    }

    private void print(Stack stack) {
        Stack cloneStack = (Stack) stack.clone();
        while (!cloneStack.empty()) {
            System.out.println(cloneStack.peek());
            cloneStack.pop();
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        Problem1 problem1 = new Problem1();
        problem1.print(stack);
        System.out.println("============================");
        stack = problem1.reverseStack(stack);
        problem1.print(stack);
        System.out.println("============================");
        problem1.reverseStackRecursive(stack);
        problem1.print(stack);

    }
}
