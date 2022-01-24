package problems.coding_interview._04_queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Problem2 {
    //    최대 n개 만큼의 가장 최근에 접근한 데이터를 캐싱하는 LRU (least recently used) 캐시를 구현하라.
    //    입력값 number는 1부터 100까지의 숫자가 랜덤하게 입력된다. 그 중에 최대 n (1보다 크고 9보다 작은)개 만큼의 데이터만 캐시할 수 있다.
    //    n개를 넘는 새로운 값이 들어오면 그 중에서 가장 오래전에 접근한 데이터를 삭제하고 number를 캐시에 추가한다.
    //    다음 오퍼레이션을 구현하라.
    //    ● query(int number): number에 해당하는 입력값을 캐시에 추가한다.
    //    ● print() 현재 캐시하고 있는 데이터를 출력한다.

    private int cacheSize;
    private HashMap<Integer, Node> map;
    private Node head, tail;

    private class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;
    }

    public Problem2(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();
    }

    private void query(int n) {
        if (map.containsKey(n)) {
            Node node = map.get(n);
            remove(node);
            addToHead(node);
        } else {
            Node nodeToAdd = new Node();
            nodeToAdd.value = n;
            if (map.size() == this.cacheSize) {
                map.remove(tail.value);
                remove(tail);
            }
            addToHead(nodeToAdd);
            map.put(n, nodeToAdd);
        }
    }

    private void addToHead(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = head;
        }
    }

    private void remove(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void print() {
        Node current = this.head;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 5, 3, 2, 2, 4};
        Problem2 LRUCache = new Problem2(3);
        for (int n : arr) {
            LRUCache.query(n);
        }
        LRUCache.print();
    }

}
