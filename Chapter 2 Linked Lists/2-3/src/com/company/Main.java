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
    void deleteMiddle(LinkedListNode target) {
        if (target == null || target.next == null) {
            return;
        }
        LinkedListNode next = target.next;
        target.data = next.data;
        target.next = next.next;
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
        sol.deleteMiddle(node0);
        System.out.println(node0);
    }

}
