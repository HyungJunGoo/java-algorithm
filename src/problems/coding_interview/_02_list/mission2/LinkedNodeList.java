package problems.coding_interview._02_list.mission2;


import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedNodeList {

    private LinkedNode head;
    private LinkedNode tail;


    public void add(LinkedNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }

    public void print() {
        LinkedNode nodeToprint = this.head;
        while (nodeToprint != null) {
            System.out.println(nodeToprint.v);
            nodeToprint = nodeToprint.next;
        }
    }

    private void reverse1() {
        // use iterate
        LinkedNode current = this.head;
        LinkedNode prev = null;
        LinkedNode next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.tail = this.head;
        this.head = prev;
    }

    private void reverse2() {
        LinkedNode head = this.head;
        this.head = recursive(head);
        this.tail = head;
    }

    private LinkedNode recursive(LinkedNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        LinkedNode newHead = recursive(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;

    }

    public String findFromLast1(int n) {
        HashMap<Integer, String> indexMap = new HashMap<>();
        Integer index = 0;
        LinkedNode head = this.head;
        while (head != null) {
            indexMap.put(index++, head.v);
            head = head.next;
        }
        return indexMap.get(indexMap.size()-n);
    }

    public String findFromLast2(int n) {
        LinkedNode head = this.head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        int target = length - n;
        LinkedNode ret = this.head;
        while (target > 0) {
            target--;
            ret = ret.next;
        }
        return ret.v;
    }


    public String findFromLast3(int n) {
        LinkedNode left = this.head, right = this.head;
        int distance = 0;
        while (right.next != null) {
            if (distance == n - 1) {
                left = left.next;
                right = right.next;
            } else if (distance < n - 1) {
                distance++;
                right = right.next;
            }

        }
        return left.v;
    }

    public LinkedNode findMid() {
        int size = 0;
        LinkedNode head = this.head;
        while (head != null) {
            size++;
            head = head.next;
        }
        size = size / 2;
        LinkedNode ret = this.head;
        while (size > 0) {
            size--;
            ret = ret.next;
        }
        return ret;
    }

    // 'a' -> 'b' -> 'b' -> 'c' -> 'c' -> 'd'
    public void removeDuplicate1() {
        LinkedNode current = this.head, next = this.head;
        while (current != null && next != null) {
            if (current.v.equals(next.v)) {
                next = next.next;
            } else {
                current.next = next;
                current = next;
            }
        }
    }

    public void removeDuplicate2() {
        // Hash Set 은 정렬이 안되어있을 경우도 사용 가능
        Set<String> vSet = new HashSet<>();
        LinkedNode prev = null, current = this.head;
        while (current != null) {
            if (vSet.contains(current.v)) {
                prev.next = current.next;
            } else {
                vSet.add(current.v);
                prev = current;
            }
            current = current.next;
        }
    }

    // 'a' -> 'b' -> 'b' -> 'c' -> 'c' -> 'd'
    public void removeDuplicate3() {
        // 재귀적 풀이
        LinkedNode current = this.head;
        recursiveRemoveDuplicate(current);
    }

    private LinkedNode recursiveRemoveDuplicate(LinkedNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        if (node.next != null) {
            if (node.v.equals(node.next.v)) {
                node.next = node.next.next;
                recursiveRemoveDuplicate(node);
            } else {
                recursiveRemoveDuplicate(node.next);
            }
        }
        return node;
    }

    // 1 -> 2 -> 2 -> 3   =>  1 -> 3
    public void removeAllDuplicates() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        LinkedNode node = this.head;
        while (node != null) {
            if (!hashMap.containsKey(node.v)) {
                hashMap.put(node.v, 1);
            } else {
                hashMap.put(node.v, hashMap.get(node.v) + 1);
            }
            node = node.next;
        }
        LinkedNode newHead = null;
        node = this.head;
        while (node != null) {
            if (hashMap.get(node.v) == 1) {
                if (newHead != null) {
                    newHead.next = node;
                }
                newHead = node;
            }
            node = node.next;
        }

    }

    public boolean findCirculatory() {
        HashSet<LinkedNode> hashSet = new HashSet<>();
        LinkedNode current = this.head;
        while (current != null) {
            if (hashSet.contains(current)) {
                return true;
            } else {
                hashSet.add(current);
            }
            current = current.next;
        }
        return false;
    }
}
