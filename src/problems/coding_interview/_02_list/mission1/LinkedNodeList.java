package problems.coding_interview._02_list.mission1;


public class LinkedNodeList {

    private LinkedNode head;
    private LinkedNode tail;

    public static void main(String[] args) {
        LinkedNodeList list = new LinkedNodeList();
        list.add(new LinkedNode("apple"));
        list.add(new LinkedNode("kiwi"));
        list.add(new LinkedNode("banana"));

        list.print();
        list.reverse2();
        list.print();

    }

    private void add(LinkedNode node) {
        if (head == null) {
            head = node;
            tail = node;
        } else if (tail != null) {
            tail.next = node;
            tail = tail.next;
        }
    }

    private void print() {
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

}
