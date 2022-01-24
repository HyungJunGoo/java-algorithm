package problems.coding_interview._04_queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Problem3 {

//    바이너리 트리의 계층별 합계 중에 최대 값을 구하라.
//            9 ->9
//            2 3 ->5
//            1 5 4 ->10
//            ==========> 10

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private static int maxLevel(Node root) {
        int ret = 0;
        Queue<Node> currentQueue = new ArrayDeque<>();
        Queue<Node> nextQueue = new ArrayDeque<>();

        currentQueue.offer(root);
        int val = 0;
        while (!currentQueue.isEmpty()) {
            Node first = currentQueue.poll();
            val += first.val;

            if (first.left != null) {
                nextQueue.offer(first.left);
            }
            if (first.right != null) {
                nextQueue.offer(first.right);
            }

            if (currentQueue.isEmpty()) {
                ret = Math.max(ret, val);
                val = 0;
                if (!nextQueue.isEmpty()) {
                    Queue<Node> temp = currentQueue;
                    currentQueue = nextQueue;
                    nextQueue = temp;
                }
            }

        }
        System.out.println("ret = " + ret);
        return ret;
    }

    public static void main(String[] args) {

        Node root = new Node(9);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(1);
        root.left.right = new Node(5);
        root.right.left = new Node(4);

        System.out.println(maxLevel(root) == 10);

    }
}
