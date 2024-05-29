package com.leetcode;

public class lc138_alter {

    public static void main(String[] args) {
        lc138_alter s = new lc138_alter();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
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
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node tmp1 = null;
        Node h1 = head;
        while (h1 != null) {
            tmp1 = h1.next;
            Node newNode = new Node(h1.val);
            newNode.next = h1.next;
            h1.next = newNode;
            h1 = tmp1;
        }

        Node h2 = head;
        while (h2 != null) {
            h2.next.random = h2.random == null ? null : h2.random.next;
            h2 = h2.next.next;
        }

        Node h3 = head;
        Node tmp2 = null;
        Node trueH = null;
        while (h3 != null) {
            tmp2 = h3.next.next;
            if (h3 == head) {
                trueH = h3.next;
            }
            h3.next.next = tmp2 == null ? null : tmp2.next;
            h3.next = tmp2;
            h3 = h3.next;
        }

        return trueH;

    }

    public static class Node {

        public int val;
        public Node next;
        public Node random;

        public Node(int v) {
            val = v;
        }
    }


}

