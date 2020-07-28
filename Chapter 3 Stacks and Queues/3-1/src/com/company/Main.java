package com.company;

class Stack<Integer> {
    public Node top;

    public int size;

    public Stack() {
        this.size = 0;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    int pop() {
        int res = this.top.data;
        this.top = this.top.next;
        this.size -= 1;
        return res;
    }

    void push(int data) {
        int newMin = data < top.min ? data : top.min;
        Node newTop = new Node(data, newMin);
        newTop.next = this.top;
        this.top = newTop;
        size += 1;
    }

    int min() {
        return top.min;
    }

    private class Node {
        public int data;
        public Node next;
        private int min;
        public Node(int data, int min) {
            this.data = data;
            this.min = min;
        }
        public int getMin() {
            return this.min;
        }
    }
}

public class Main {
    public static void main(String[] args) {
	// write your code here
    }
}
