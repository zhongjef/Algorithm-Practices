package com.company;

import java.util.HashSet;

class LinkedListNode {
    public LinkedListNode next;
    public int data;
    public LinkedListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        LinkedListNode curr = this;
        StringBuilder str = new StringBuilder();
        if (curr.next != null) {
            str.append(curr.data);
            str.append(" -> ");
            curr = curr.next;
        }
        str.append(curr.data);
        return str.toString();
    }
}

class Solution {
    LinkedListNode detectLoop(LinkedListNode node) {
        if (node == null) {
            return null;
        }
        HashSet<LinkedListNode> set = new HashSet<>();
        while (node != null) {
            if (set.contains(node)) {
                return node;
            } else {
                set.add(node);
            }
            node = node.next;
        }
        return null;
    }
}

public class Main {

    public static void main(String[] args) {
        LinkedListNode node0 = new LinkedListNode(0);
        node0.next = node0;
        System.out.println(node0);
        Solution sol = new Solution();
        LinkedListNode res = sol.detectLoop(node0);
        System.out.println(res);
    }
}
