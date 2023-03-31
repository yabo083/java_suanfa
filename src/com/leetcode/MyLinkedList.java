//https://leetcode.cn/problems/design-linked-list/
package com.leetcode;

class MyLinkedList {

    private class ListNode{
        int data;
        ListNode prev;
        ListNode next;

        ListNode(int data){
            this.data = data;
        }
    }

    private int size;
    private ListNode dummyHead, dummyTail;

    public MyLinkedList() {

        size = 0;
        dummyHead = new ListNode(0);
        dummyTail = new ListNode(0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;

    }

    public int get(int index) {
        if(index < 0 || index > size)
            return -1;

        ListNode p = getPrevNode(index);
        return p.next.data;

    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index < 0)
            index = 0;
        if(index > size)
            return;


        ListNode p = getPrevNode(index);
        ListNode cur = new ListNode(val);
//        cur.prev = p;
//        cur.next = p.next;
//        p.next.prev = cur;
//        p.next = cur;
        cur.next = p.next;
        p.next.prev = cur;
        cur.prev = p;
        p.next = cur;
        size ++;
    }

    public void deleteAtIndex(int index) {

        if(index < 0 || index > size )
            return;

        ListNode p = getPrevNode(index).next;
        p.prev.next = p.next;
        p.next.prev = p.prev;
        size --;

    }

    public ListNode getPrevNode(int index){
        ListNode prevNode = dummyHead;
        if(index < size/2){
            for(int i = 0 ; i < index ; i ++){
                prevNode = prevNode.next;
            }
        }
        else{
            prevNode = dummyTail;
            for(int i = 0 ; i <= size - index ; i ++){
                prevNode = prevNode.prev;
            }
        }
        return prevNode;
    }
}

