package com.company;

import java.util.Stack;

abstract class LinkedListNode {
    public int data;
    LinkedListNode(int data) {
        this.data = data;
    }
}

class DoublyLinkedListNode extends LinkedListNode{
    public DoublyLinkedListNode prev, next;
    DoublyLinkedListNode(int data) {
        super(data);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        DoublyLinkedListNode curr = this;
        while (curr.next != null) {
            str.append(curr.data);
            str.append(" <-> ");
            curr = curr.next;
        }
        str.append(curr.data);
        return str.toString();
    }
}

class SinglyLinkedListNode extends LinkedListNode {
    public SinglyLinkedListNode next;
    SinglyLinkedListNode(int data) {
        super(data);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        SinglyLinkedListNode curr = this;
        while (curr.next != null) {
            str.append(curr.data);
            str.append(" -> ");
            curr = curr.next;
        }
        str.append(curr.data);
        return str.toString();
    }
}

class Solution {
    // Doubly linked list, do not use extra data structure
    boolean isPalindrome(DoublyLinkedListNode node) {
        DoublyLinkedListNode back = node;
        while (back.next != null) {
            back = back.next;
        }
        DoublyLinkedListNode front = node;
        while (front != back && front.prev != back) {
            if (front.data != back.data) {
                return false;
            }
            front = front.next;
            back = back.prev;
        }
        return true;
    }

    // Singly linked list, use extra data structure
    boolean isPalindrome(SinglyLinkedListNode node) {
        Stack<Integer> stack = new Stack<>();
        SinglyLinkedListNode curr = node;
        while (curr != null) {
            stack.push(curr.data);
            curr = curr.next;
        }
        curr = node;
        while (curr != null) {
            if (curr.data != stack.pop()) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }
}

public class Main {

    public static void main(String[] args) {
	    DoublyLinkedListNode dnode0 = new DoublyLinkedListNode(0);
        DoublyLinkedListNode dnode1 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode dnode2 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode dnode3 = new DoublyLinkedListNode(2);
        DoublyLinkedListNode dnode4 = new DoublyLinkedListNode(1);
        DoublyLinkedListNode dnode5 = new DoublyLinkedListNode(0);
        dnode0.next = dnode1;
        dnode1.next = dnode2;
        dnode2.next = dnode3;
        dnode3.next = dnode4;
        dnode4.next = dnode5;
        dnode1.prev = dnode0;
        dnode2.prev = dnode1;
        dnode3.prev = dnode2;
        dnode4.prev = dnode3;
        dnode5.prev = dnode4;

        SinglyLinkedListNode snode0 = new SinglyLinkedListNode(0);
        SinglyLinkedListNode snode1 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode snode2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode snode3 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode snode4 = new SinglyLinkedListNode(1);
        SinglyLinkedListNode snode5 = new SinglyLinkedListNode(0);
        snode0.next = snode1;
        snode1.next = snode2;
        snode2.next = snode3;
        snode3.next = snode4;
        snode4.next = snode5;


        Solution sol = new Solution();
        boolean res1 = sol.isPalindrome(dnode0);
        boolean res2 = sol.isPalindrome(snode0);
        System.out.println(res1);
        System.out.println(res2);
    }
}
