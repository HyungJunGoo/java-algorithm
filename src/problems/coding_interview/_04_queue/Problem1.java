package problems.coding_interview._04_queue;

import problems.coding_interview._03_stack.Problem5;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem1 {
    //    큐가 제공하는 오퍼레이션만 사용해서 큐를 뒤집는 코드를 작성하라. 제공하는 오퍼레이션은 다음과 같다.
    //            1. offer(E e): 큐의 끝에 데이터를 추가한다.
    //            2. E poll(): 큐 헤드를 꺼낸다.
    //3. isEmpty(): 큐가 비어있는가.
    //    예)Q{1,2,3} => Q{3,2,1}
    private Queue<Integer> reverseQueue(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return queue;
        }

        Integer n = queue.poll();
        Queue<Integer> reversedQ = reverseQueue(queue);
        reversedQ.offer(n);
        return reversedQ;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        for (Integer integer : queue) {
            System.out.println(integer);
        }
        Problem1 problem1 = new Problem1();
        Queue<Integer> integers = problem1.reverseQueue(queue);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
