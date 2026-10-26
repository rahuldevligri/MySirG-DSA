package c_Stack;

public class Assignment_7 {

    public void assignment7() {
        StackUsingArrays s1 = new StackUsingArrays(4);
        System.out.println("Overflow: " + s1.isFull() + " or Underflow: " + s1.isEmpty());

        s1.push(10);
        System.out.println(s1.peek());

        s1.push(20);
        System.out.println(s1.peek());

        System.out.println(s1.pop());
        System.out.println(s1.peek());
    }
}

class StackUsingArrays {
    private int top;
    private int[] ptr;

    // Parameterized constructor
    StackUsingArrays(int size) {
        ptr = new int[size];
        top = -1;
    }

    // Push new element
    void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        ptr[++top] = data;
    }

    // Peek top element
    int peek() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return ptr[top];
    }

    // Pop top element
    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        return ptr[top--];
    }

    // Stack Overflow
    boolean isFull() {
        return top == ptr.length - 1;
    }

    // Stack Underflow
    public boolean isEmpty() {
        return top == -1;
    }
}