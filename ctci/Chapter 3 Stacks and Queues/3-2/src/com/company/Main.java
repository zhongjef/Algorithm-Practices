package com.company;

import java.util.Stack;

/***
 * First approach, augmenting stack node with a minimum value of current state
 */
class MinStack {
    public Node top;
    public int size;

    public MinStack() {
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

/***
 * Two stack augmented, one for data, one for minimum
 */
class DoubleStack {
    private class Node {
        int data;
        Node(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return Integer.toString(this.data);
        }
    }

    Stack<Node> dataStack;
    Stack<Node> minimumStack;

    public DoubleStack() {
        dataStack = new Stack<>();
        minimumStack = new Stack<>();
    }

    int pop() {
        if (dataStack.isEmpty()) {
            return Integer.MAX_VALUE;
        }

        Node res = dataStack.pop();
        if (res == minimumStack.peek()) {
            minimumStack.pop();
        }
        return res.data;
    }

    void push(int data) {
        Node newNode = new Node(data);
        dataStack.push(newNode);
        if (!minimumStack.isEmpty()) {
            Node currMin = minimumStack.peek();
            if (currMin.data > data) {
                minimumStack.push(newNode);
            }
        } else {
            minimumStack.push(newNode);
        }

    }

    int peek() {
        if (!dataStack.isEmpty()) {
            return dataStack.peek().data;
        }
        return Integer.MAX_VALUE;
    }

    int min() {
        if (!minimumStack.isEmpty()) {
            return minimumStack.peek().data;
        }
        return Integer.MAX_VALUE;
    }
}

public class Main {
    public static void main(String[] args) {
	    DoubleStack stack = new DoubleStack();
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
