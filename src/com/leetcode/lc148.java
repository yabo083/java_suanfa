package com.leetcode;

public class lc148 {

    public static ListNode start;
    public static ListNode end;

    public static ListNode findEnd(ListNode s, int k) {
        while (s.next != null && --k != 0) {
            s = s.next;
        }
        return s;
    }

    public static void merge(ListNode l1, ListNode r1, ListNode l2, ListNode r2) {
        ListNode pre;
        if (l1.val <= l2.val) {
            start = l1;
            pre = l1;
            l1 = l1.next;
        } else {
            start = l2;
            pre = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = l2;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
            end = r1;
        } else {
            pre.next = l2;
            end = r2;
        }
    }

    public ListNode sortList(ListNode head) {
        ListNode cur = head;
        int n = 0;

        while (cur != null) {
            n++;
            cur = cur.next;
        }

        ListNode l1, r1, l2, r2, next, last;
        for (int step = 1; step < n; step <<= 1) {
            l1 = head;
            r1 = findEnd(l1, step);
            l2 = r1.next;
            r2 = findEnd(l2, step);

            // 别的不说，先把下一组准备好
            next = r2.next;

            // 断掉，是为了归并
            r1.next = null;
            r2.next = null;
            merge(l1, r1, l2, r2);

            head = start;
            last = end;

            while (next != null) {
                l1 = next;
                r1 = findEnd(l1, step);
                l2 = r1.next;

                // 确实能涵盖大多数情况
                if (l2 == null) {
                    last.next = l1;
                    break;
                }
                r2 = findEnd(l2, step);

                next = r2.next;

                r1.next = null;
                r2.next = null;

                merge(l1, r1, l2, r2);
                last.next = start;
                last = end;
            }
        }
        return head;
    }

    public static class ListNode {

        public int val;
        public ListNode next;
    }

    public static void main(String[] args) {
        lc148 s = new lc148();
        ListNode n1 = new ListNode();
        ListNode n2 = new ListNode();
        ListNode n3 = new ListNode();
        ListNode n4 = new ListNode();
        ListNode n5 = new ListNode();
        n1.val = 4;
        n2.val = 2;
        n3.val = 1;
        n4.val = 3;
        n5.val = 5;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode n = s.sortList(n1);
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }

}
