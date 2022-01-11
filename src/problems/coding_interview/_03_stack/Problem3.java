package problems.coding_interview._03_stack;

import java.util.Stack;

public class Problem3 {
    /**
     * 문제. 괄호 몇개를 뒤집어야 정상적인 수식을 만들 수 있는지 계산하는 코드를 작성하라.
     * <p>
     * 예) {{{}} => exception
     * <p>
     * 예) {{{{}} => 1
     * <p>
     * 예) }}}}{}}} => 3
     */
    private int solution(String brackets) {
        Stack<Character> stack = new Stack<>();
        char[] chars = brackets.toCharArray();
        for (char c : chars) {
            if (c == '{') {
                stack.push(c);
            } else {
                if (!stack.empty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        if (stack.size() % 2 == 1) {
            throw new RuntimeException("Invalid input");
        }
        return stack.size() / 2;
    }
    public static void main(String[] args) {
        String s = "}}}}{}}}";
        Problem3 problem3 = new Problem3();
        int solution = problem3.solution(s);
        System.out.println("solution = " + solution);
    }
}
