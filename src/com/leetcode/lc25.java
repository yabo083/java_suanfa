package com.leetcode;

class lc25 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode[] tureHT = new ListNode[3];

    public static ListNode[] reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next;
        ListNode tail = head;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        tureHT[0] = pre;
        tureHT[1] = tail;
        return tureHT;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        int n = 1;
        ListNode h = head;
        ListNode trueH = head,trueT = null, tmpN, tmpH = null;
        while (h != null && h.next != null) {
            h = h.next;
            if (++ n  % k == 0){
                tmpN = h.next;
                h.next = null;
                if (n / k == 1){
                    ListNode[] nodes = reverseList(head);
                    trueH = nodes[0];
                    trueT = nodes[1];
                    trueT.next = tmpN;
                    h = trueT;
                } else {
                    ListNode[] nodes = reverseList(trueT.next);
                    tmpH = nodes[0];
                    trueT.next = tmpH;
                    trueT = nodes[1];
                    trueT.next = tmpN;
                    h = trueT;
                }
            }
        }
        return trueH;
    }

    public static void main(String[] args) {
        // use collection class to test
        lc25 solution = new lc25();
        ListNode head = solution.new ListNode(1);
        ListNode tmp = head;


        // use random method to test
        for (int i = 2; i < 100; i ++) {
            tmp.next = solution.new ListNode((int)(Math.random() * 100));
            tmp = tmp.next;
        }






        ListNode res = solution.reverseKGroup(head, (int)(Math.random() * 10));
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}

