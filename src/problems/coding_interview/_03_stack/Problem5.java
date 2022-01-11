package problems.coding_interview._03_stack;

import java.util.Arrays;
import java.util.Stack;

public class Problem5 {
    //    주어진 배열 prices에 대한 스팬을 구하는 코드를 작성하라. 스팬: 당일의 주가 보다 낮거나 같았던 연속적인 일 수.
    //    예)[5,3,2,4,7,1] => [1,1,1,3,5,1]
    //    예)[2,3,4,5,6,7] => [1,2,3,4,5,6]
    private int[] solution(int[] prices) {
        int[] ret = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        ret[0] = 1;
        stack.push(0);
        for (int i = 1; i < prices.length; i++) {
            if (prices[stack.peek()] > prices[i]) {
                ret[i] = 1;
                stack.push(i);
            } else {
                while (!stack.empty() && prices[stack.peek()] < prices[i]) {
                    stack.pop();
                }
                if (stack.empty()) {
                    ret[i] = i + 1;
                } else {
                    ret[i] = i - stack.peek();
                }
                stack.push(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] prices1 = {5, 3, 2, 4, 7, 1};
        int[] prices2 = {2, 3, 4, 5, 6, 7};
        Problem5 problem5 = new Problem5();
        int[] solution1 = problem5.solution(prices1);
        int[] solution2 = problem5.solution(prices2);

        System.out.println("solution1 = " + Arrays.toString(solution1));
        System.out.println("solution2 = " + Arrays.toString(solution2));
    }

}
