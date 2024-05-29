package com.leetcode;

public class lc234 {

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode f = head, s = head, h = head, t = null;
        while (f.next != null && f.next.next != null && s.next != null) {
            f = f.next.next;
            s = s.next;
        }

        if (f.next != null) {
            t = reverseList(s.next);
            s.next = null;
        } else {
            t = reverseList(s);
        }

//        while (h.next != null && t.next != null) {
//            if (h.val != t.val) {
//                return false;
//            }
//            h = h.next;
//            t = t.next;
//        }
        while (h != null && t != null) {
            if (h.val != t.val) {
                return false;
            }
            h = h.next == null ? null : h.next;
            t = t.next == null ? null : t.next;
        }

        if (f.next != null) {
            f = reverseList(f.next);
            s.next = f;
        } else {
            reverseList(f);
        }

        return true;
    }

    public static class ListNode {

        public int val;
        public ListNode next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode();
        ListNode n2 = new ListNode();
        ListNode n3 = new ListNode();
        ListNode n4 = new ListNode();

        n1.val = 1;
        n2.val = 2;
        n3.val = 2;
        n4.val = 0;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println(new lc234().isPalindrome(n1));
    }

}
