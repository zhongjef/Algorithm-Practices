package com.company;

class Stack {
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
        int newMin = top == null ? data : Math.min(top.min, data);
        Node newTop = new Node(data, newMin);
        newTop.next = this.top;
        this.top = newTop;
        size += 1;
    }

    Integer min() {
        if (this.isEmpty()) return null;
        return this.top.min;
    }

    private class Node {
        public int data;
        public Node next;
        public int min;
        public Node(int data, int min) {
            this.data = data;
            this.min = min;
        }
    }
}

public class Main {
    public static void main(String[] args) {
	    Stack stack = new Stack();
	    stack.push(1);
	    stack.push(2);
	    stack.push(3);
        System.out.println(stack.min());
        System.out.println(stack.pop());
        System.out.println(stack.min());
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
    }
}
