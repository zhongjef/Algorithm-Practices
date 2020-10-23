package com.company;


enum Stack {
    ONE, TWO, THREE
}

class Node {
    int data;
    Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return Integer.toString(this.data);
    }
}

class ArrStack {
    private final int SIZE_FACTOR = 3;
    private final int EXPAND_FACTOR = 2;
    int stack1Size, stack2Size, stack3Size;
    Node[] nodeArr;

    ArrStack() {
        this.stack1Size = 0;
        this.stack2Size = 0;
        this.stack3Size = 0;
        nodeArr = new Node[SIZE_FACTOR];
    }

    int totalCapacity() {
        return nodeArr.length;
    }

    int stackCapacity() {
        return this.totalCapacity() / SIZE_FACTOR;
    }

    boolean isFull(Stack stackID) {
        switch (stackID) {
            case ONE:
                return stack1Size == this.stackCapacity();
            case TWO:
                return stack2Size == this.stackCapacity();
            case THREE:
                return stack3Size == this.stackCapacity();
        }
        return true;
    }

    boolean isEmpty(Stack stackID) {
        switch (stackID) {
            case ONE:
                return stack1Size == 0;
            case TWO:
                return stack2Size == 0;
            case THREE:
                return stack3Size == 0;
        }
        return true;
    }

    void push(Stack stackID, int data) {
        int offset = 0;
        switch (stackID) {
            case ONE:
                nodeArr[stack1Size] = new Node(data);
                stack1Size++;
                break;
            case TWO:
                offset = this.stackCapacity();
                nodeArr[stack2Size + offset] = new Node(data);
                stack2Size++;
                break;
            case THREE:
                offset = 2 * this.stackCapacity();
                nodeArr[stack3Size + offset] = new Node(data);
                break;
        }
        if (this.isFull(stackID)) {
            this.expand();
        }
    }

    int pop(Stack stackID) {
        if (this.isFull(stackID)) {
            return Integer.MAX_VALUE;
        }
        int res;
        switch (stackID) {
            case ONE:
                stack1Size--;
                res = nodeArr[stack1Size].data;
                nodeArr[stack1Size] = null;
                return res;
            case TWO:
                stack2Size--;
                res = nodeArr[stack2Size].data;
                nodeArr[stack2Size] = null;
                return res;
            case THREE:
                stack3Size--;
                res = nodeArr[stack3Size].data;
                nodeArr[stack3Size] = null;
                return res;
        }
        return Integer.MAX_VALUE;
    }

    // eager expansion
    private void expand() {
        int currCapacity = this.totalCapacity();
        int newCapacity = currCapacity * EXPAND_FACTOR;
        Node[] newNodeArr = new Node[newCapacity];
        int i = 0;
        // [0, n/3)
        while (i < currCapacity / 3) {
            newNodeArr[i] = nodeArr[i];
            i++;
        }
        int j = 2 * i;
        // [n/3, 2n/3)
        while (i < 2 * currCapacity / 3) {
            newNodeArr[j] = nodeArr[i];
            j++;
            i++;
        }
        j = 2 * i;
        // [2n/3, n)
        while (i < currCapacity) {
            newNodeArr[j] = nodeArr[i];
            j++;
            i++;
        }
        this.nodeArr = newNodeArr;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int stack = 1; stack <= 3; stack++) {
            int i = (stack - 1) * this.stackCapacity();
            str.append(String.format("Stack%d: ", stack));
            while (i < (stack) * this.stackCapacity()) {
                str.append(nodeArr[i]);
                str.append(" ");
                i++;
            }
            str.append(System.lineSeparator());
        }
        return str.toString();
    }
}

public class Main {

    public static void main(String[] args) {
	    ArrStack arrStack = new ArrStack();
	    arrStack.push(Stack.ONE, 1);
        arrStack.push(Stack.ONE, 2);
        arrStack.push(Stack.ONE, 3);
        arrStack.pop(Stack.ONE);
        System.out.println(arrStack);
        System.out.println(arrStack.isEmpty(Stack.TWO));
    }
}
