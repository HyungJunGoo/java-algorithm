package problems.coding_interview._03_stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Problem2 {

    /**
     * 문제. 괄호 수식과 여는 괄호의 위치가 주어졌을 때 그에 대응하는 닫힌 괄호의 위치를 찾는 코드를 작성하라.
     * 대응 하는 괄호가 나타나지 않으면 -1을 반환,
     * <p>
     * 예) [{1+2*(2+2)}-(1-3)], 1   => 11 (‘{‘에 대응하는 ‘}’가 11번째 위치에 있다.
     */

    private int solution(String mathExpression, int position) {
        char[] chars = mathExpression.toCharArray();
        Stack<Character> stack = new Stack<>();
        List<Character> openBrackets = Arrays.asList('(', '{', '[');
        List<Character> closeBrackets = Arrays.asList(')', '}', ']');
        stack.push(chars[position]);
        for (int i = position+1; i < mathExpression.length(); i++) {
            char c = chars[i];
            if (openBrackets.contains(c)) {
                stack.push(c);
            } else if (closeBrackets.contains(c)) {
                Character openingBracket = stack.pop();
                if (openBrackets.indexOf(openingBracket) != closeBrackets.indexOf(c)) {
                    return -1;
                }
                if (stack.empty()) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String mathExpression = "[{1+2*(2+2)}-(1-3)]";
        Problem2 problem2 = new Problem2();
        int i = problem2.solution(mathExpression, 1);
        System.out.println("i = " + i);

    }
}
