package com.company;

import com.sun.jdi.connect.spi.TransportService;

class LinkedListNode {
    public LinkedListNode next;
    public int data;
    LinkedListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        LinkedListNode curr = this;
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
    LinkedListNode partition(LinkedListNode node, int pivot) {
        LinkedListNode head = node;
        LinkedListNode tail = node;
        while (node != null) {
            LinkedListNode next = node.next;
            if (node.data < pivot) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }
}

public class Main {

    public static void main(String[] args) {
	    LinkedListNode node0 = new LinkedListNode(3);
	    LinkedListNode node1 = new LinkedListNode(5);
	    LinkedListNode node2 = new LinkedListNode(8);
	    LinkedListNode node3 = new LinkedListNode(5);
	    LinkedListNode node4 = new LinkedListNode(10);
	    LinkedListNode node5 = new LinkedListNode(2);
	    LinkedListNode node6 = new LinkedListNode(1);
	    node0.next = node1;
	    node1.next = node2;
	    node2.next = node3;
	    node3.next = node4;
	    node4.next = node5;
	    node5.next = node6;
        System.out.println(node0);
        Solution sol = new Solution();
        LinkedListNode partition = sol.partition(node0, 5);
        System.out.println(partition);
    }
}
