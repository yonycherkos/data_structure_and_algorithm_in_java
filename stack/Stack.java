package stack;

public class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        this.arr = new int[size];
        this.top = -1;
        this.capacity = size;
    }

    public void push(int data) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        top++;
        arr[top] = data;
    }

    public int pop() {
        if (isEmtpy()) {
            throw new StackOverflowError("Stack is empty");
        }
        int result = arr[top];
        top--;
        return result;
    }

    public int peak() {
        if (isEmtpy()) {
            throw new StackOverflowError("Stack is empty");
        }
        return arr[top];
    }

    public boolean isEmtpy() {
        return top == -1;
    }

    public boolean isFull() {
        return capacity - 1 == top;
    }

    public int size() {
        return capacity;
    }

    public static void main(String[] args) {
    }
}
