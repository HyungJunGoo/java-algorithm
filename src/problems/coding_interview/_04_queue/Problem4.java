package problems.coding_interview._04_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem4 {

    //    큐 인스턴스를 사용해서 Stack 인터페이스를 구현하라.
//    pop() 오퍼레이션은 가장 마지막으로 추가한 값을 꺼내야 한다. push() 오퍼레이션은 값을 추가한다.
//    큐가 제공하는 offer(), poll(), isEmpty(), size()만 사용할 수 있다. Deque는 사용하지 못한다.
//    (힌트) 큐 인스턴스를 여러개 사용할 수 있다.
    public static class QueueStack<E> {

        private Queue<E> q1 = new ArrayDeque<>();
        private Queue<E> q2 = new ArrayDeque<>();

        public void push(E val) {
            q2.offer(val);

            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }

            Queue<E> temp = q1;
            q1 = q2;
            q2 = temp;
        }
        public E pop() {
            if (!q1.isEmpty()) {
                return q1.poll();
            } else {
                return null;
            }
        }

        public boolean isEmpty() {
            if (q1.size() == 0) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        QueueStack stack = new QueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
