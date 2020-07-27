package com.company;

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
        while (curr.next != null) {
            str.append(curr.data);
            str.append(" -> ");
            curr = curr.next;
        }
        str.append(curr.data);
        return str.toString();
    }
}

class Result {
    public LinkedListNode tail;
    public int length;
    public Result(LinkedListNode tail, int length) {
        this.tail = tail;
        this.length = length;
    }
}

class Solution {
    Result getTailAndLength(LinkedListNode node) {
        int length = 1;
        while (node.next != null) {
            length++;
            node = node.next;
        }
        return new Result(node, length);
    }

    LinkedListNode findIntersect(LinkedListNode n1, LinkedListNode n2) {
        if (n1 == null || n2 == null) {
            return null;
        }

        Result tailAndLengthOfn1 = getTailAndLength(n1);
        Result tailAndLengthOfn2 = getTailAndLength(n2);
        LinkedListNode endOfn1 = tailAndLengthOfn1.tail;
        LinkedListNode endOfn2 = tailAndLengthOfn2.tail;
        int lenOfn1 = tailAndLengthOfn1.length;
        int lenOfn2 = tailAndLengthOfn2.length;

        // If an intersection exists, end of n1 and n2 must match
        if (endOfn1 != endOfn2) {
            return null;
        }
        // Trim the prevailing nodes in the longer list to find the intersection
        LinkedListNode longerNode = lenOfn1 > lenOfn2 ? n1 : n2;
        LinkedListNode shorterNode = lenOfn1 > lenOfn2 ? n2 : n1;
        for (int i = 0; i < Math.abs(lenOfn1 - lenOfn2); i++) {
            longerNode = longerNode.next;
        }
        while (longerNode != shorterNode) {
            longerNode = longerNode.next;
            shorterNode = shorterNode.next;
        }
        return longerNode;
    }
}

public class Main {

    public static void main(String[] args) {
	    LinkedListNode node0 = new LinkedListNode(0);
	    LinkedListNode node1 = new LinkedListNode(1);
	    LinkedListNode node2 = new LinkedListNode(2);
	    LinkedListNode node3 = new LinkedListNode(3);
	    LinkedListNode node4 = new LinkedListNode(4);
	    node0.next = node1;
	    node1.next = node2;
	    node2.next = node3;
	    node3.next = node4;
        System.out.println(node0);
        Solution sol = new Solution();
        LinkedListNode res = sol.findIntersect(node1, node0);
        System.out.println(res);
    }
}
