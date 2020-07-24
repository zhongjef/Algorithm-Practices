package com.company;

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
        return  str.toString();
    }
}

class Solution {
//    // Backward base 10 digit representation, 7 -> 1 -> 6 = 617
//    int sumList(LinkedListNode n1, LinkedListNode n2) {
//        int base = 1;
//        int sum = 0;
//        while (n1 != null && n2 != null) {
//            sum += (n1.data + n2.data) * base;
//            base *= 10;
//            n1 = n1.next;
//            n2 = n2.next;
//        }
//        LinkedListNode remainder = n1 != null ? n1 : n2;
//        while (remainder != null) {
//            sum += remainder.data * base;
//            base *= 10;
//            remainder = remainder.next;
//        }
//        return sum;
//    }

    // Forward base 10 digit representation, 7 -> 1 -> 6 = 716
    int sumList(LinkedListNode n1, LinkedListNode n2) {
        int base = 1;
        LinkedListNode n1Head = n1;
        LinkedListNode n2Head = n2;

        while (n1 != null && n2 != null) {
            if (n1.next == null && n2.next != null) {
                n1.next = new LinkedListNode(0);
            }
            if (n1.next != null && n2.next == null) {
                n2.next = new LinkedListNode(0);
            }
            base *= 10;
            n1 = n1.next;
            n2 = n2.next;
        }

        n1 = n1Head;
        n2 = n2Head;
        int sum = 0;
        while (n1 != null && n2 != null) {
            base /= 10;
            sum += (n1.data + n2.data) * base;
            n1 = n1.next;
            n2 = n2.next;
        }
        return sum;
    }

}

public class Main {

    public static void main(String[] args) {
	    LinkedListNode node0 = new LinkedListNode(7);
        LinkedListNode node1 = new LinkedListNode(1);
        LinkedListNode node2 = new LinkedListNode(6);
        node0.next = node1;
        node1.next = node2;
        LinkedListNode node3 = new LinkedListNode(5);
        LinkedListNode node4 = new LinkedListNode(9);
        LinkedListNode node5 = new LinkedListNode(2);
        node3.next = node4;
        node4.next = node5;
        Solution sol = new Solution();
        int res = sol.sumList(node0, node3);
        System.out.println(res);
    }
}
