package problems.coding_interview._03_stack;

import java.util.Stack;

public class Problem4 {
    //    포스트픽스로 주어진 식을 계산하는 코드를 작성하라. 수식은 사칙연산 (+, -, *, /)만 사용한다고 가정한다.
    //    식에 주어지는 숫자는 모두 한 자리로 가정한다.
    //    예) 12+ => 3
    //    예) 123+-5* => -20

    private int solution(String mathExp) {
        mathExp = mathExp.trim();
        Stack<Integer> stack = new Stack<>();
        for (char c : mathExp.toCharArray()) {
            if (c == '+' || c == '-' || c=='*' || c=='/') {
                int right = stack.pop();
                int left = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(left - right);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    case '/':
                        stack.push(left / right);
                        break;
                }
            } else if (Character.isDigit(c)) {
                stack.push(c - '0');
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {

        Problem4 problem = new Problem4();
        int ret1 = problem.solution("12+");
        System.out.println("ret1 = " + ret1);

        int ret2 = problem.solution("123+-5*");
        System.out.println("ret2 = " + ret2);
    }
}
