package com.leetcode;
// Definition for a ListNode.


import java.util.HashMap;

class lc138 {
    public class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Node h = head;
        HashMap<Node, Node> map = new HashMap<>();
        while(head!= null){
            map.put(head, new Node(head.val));
            head = head.next;
        }
        Node newHead = map.get(h);
        Node cur = newHead;
        while(h != null){
            cur.next = map.get(h.next);
            cur.random = map.get(h.random);
            h = h.next;
            cur = cur.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        lc138 s = new lc138();
        Node n1 = s.new Node(1);
        Node n2 = s.new Node(2);
        Node n3 = s.new Node(3);
        Node n4 = s.new Node(4);
        Node n5 = s.new Node(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n1.random = n3;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n2;
        Node n = s.copyRandomList(n1);
        while(n != null){
            System.out.print(n.val + " ");
            n = n.next;
        }
    }


}
