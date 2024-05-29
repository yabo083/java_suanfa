package com.leetcode;

public class lc142 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode f = head, s = head;
        while (f.next != null && f.next.next != null ){
            f = f.next.next;
            s = s.next;
            if (f == s){
                f = head;
                while (f != s) {
                    f = f.next;
                    s = s.next;
                }
                return f;
            }
        }
        return null;
    }

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static void main(String[] args) {
        lc142 s = new lc142();
        ListNode n1 = new ListNode();
        ListNode n2 = new ListNode();
        ListNode n3 = new ListNode();
        ListNode n4 = new ListNode();
        ListNode n5 = new ListNode();
        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;
        n5.val = 5;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n5;
        ListNode n = s.detectCycle(n1);
        System.out.println(n.val);
    }

}
