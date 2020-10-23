package com.company;

class LinkedListNode {
    public LinkedListNode next;
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
            str.append(" -> ");
            curr = curr.next;
        }
        str.append(curr.data);
        return str.toString();
    }
}

class Solution {
    LinkedListNode findLastK(LinkedListNode node, int k) {
        if (k < 1) return null;
        LinkedListNode p1 = node;
        LinkedListNode p2 = node;
        for (int i = 0; i < k; i++) {
            if (p1 == null) return null;
            p1 = p1.next;
        }
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}

public class Main {

    public static void main(String[] args) {
        Solution sol = new Solution();
        LinkedListNode node0 = new LinkedListNode(0);
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(2);
        node0.next = node1;
        node1.next = node2;
        System.out.println(node0);
        LinkedListNode res = sol.findLastK(node0, -1);
        System.out.println(res);
    }
}
