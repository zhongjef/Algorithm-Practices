package com.company;

import java.util.HashSet;

class LinkedListNode {
    public LinkedListNode prev, next;
    public int data;
    public LinkedListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        LinkedListNode curr = this;
        while (curr.next != null) {
            str.append(curr.data);
            str.append(" <-> ");
            curr = curr.next;
        }
        str.append(curr.data);
        return str.toString();
    }
}

class Solution {
    void removeDup(LinkedListNode node) {
        if (node == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode curr = node;
        while (curr.next != null) {
            if (set.contains(curr.data)) {
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
            } else {
                set.add(curr.data);
            }
            curr = curr.next;
        }
        // Check last node
        if (set.contains(curr.data)) {
            curr.prev.next = null;
        }
    }
}

public class Main {

    public static void main(String[] args) {
	    Solution sol = new Solution();
	    LinkedListNode node0 = new LinkedListNode(0);
	    LinkedListNode node1 = new LinkedListNode(0);
	    LinkedListNode node2 = new LinkedListNode(0);
	    node0.next = node1;
	    node1.prev = node0;
	    node1.next = node2;
	    node2.prev = node1;
        System.out.println(node0);
        sol.removeDup(node0);
        System.out.println(node0);
    }
}
