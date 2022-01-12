package problems.leetcode;

import java.util.ArrayList;

public class AddTwoNumbers {
    // https://leetcode.com/problems/add-two-numbers/

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val){
            this.val = val;}
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode();
        ListNode tmp = ret;
        int add = 0;
        while (!(l1 == null && l2 == null)) {
            int n1 = (l1 == null) ? 0 : l1.val;
            int n2 = (l2 == null) ? 0 : l2.val;
            int n = n1 + n2 + add;
            if (n >= 10) {
                add = 1;
                n %= 10;
            } else {
                add = 0;
            }
            ret.next = new ListNode(n);
            ret = ret.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        if (add == 1) {
            ret.next = new ListNode(1);
        }
        return tmp.next;
    }
    public static void main(String[] args) {
        AddTwoNumbers problem = new AddTwoNumbers();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = problem.addTwoNumbers(l1, l2);
        System.out.println("result.val = " + result.val);

    }
}
