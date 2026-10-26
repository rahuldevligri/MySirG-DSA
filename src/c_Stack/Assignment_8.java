package c_Stack;

public class Assignment_8 {
    public void assignment8(){
        StackUsingLinkedList sun = new StackUsingLinkedList();
        System.out.println(sun.isEmpty());

        sun.push(10);
        System.out.println(sun.isEmpty());
        System.out.println("Peek: " + sun.peek());
        sun.display();

        sun.push(20);
        System.out.println("Peek: " + sun.peek());

        sun.push(30);
        System.out.println("Peek: " + sun.peek());
        sun.display();

        sun.pop();
        System.out.println("Peek: " + sun.peek());
        sun.display();

        sun.push(40);
        System.out.println("Peek: " + sun.peek());
        sun.display();

        sun.reverse();
        sun.display();
    }
}

class StackUsingLinkedList {
    private Node top;

    private class Node{
        Node next;
        int data;

        Node(int data){
            this.data = data;
        }
    }

    //add new element
    void push(int data){
        Node n = new Node(data);
        n.next = top;
        top = n;
    }

    //look last element
    int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty...");
            return -1;
        }
        return top.data;
    }

    //delete last element
    int pop(){
        if (isEmpty()){
            System.out.println("Stack is Empty...");
            return -1;
        }
        int pop = top.data;
        top = top.next;
        return pop;
    }

    //check Empty
    boolean isEmpty(){
        return top == null;
    }

    //reverse a stack
    void reverse(){
        Node prev = null;
        Node current = top;

        while(current != null){
            Node next = current.next;

            current.next = prev;

            prev = current;
            current = next;
        }
        top = prev;
    }

    void reverse2(){
        StackUsingLinkedList temp =  new StackUsingLinkedList();
        while(!isEmpty()){ //30, 20, 10 --> 10, 20, 30
            temp.push(pop());
        }
        StackUsingLinkedList t = new StackUsingLinkedList();
        while(!temp.isEmpty()){ //10, 20, 30 --> 30, 20, 10
            t.push(temp.pop());
        }
        while(!t.isEmpty()){ // 30, 20, 10 --> 10, 20, 30
            push(t.pop());
        }
    }

    static StackUsingLinkedList reverse3(StackUsingLinkedList s){
        StackUsingLinkedList temp =  new StackUsingLinkedList();
        while(!s.isEmpty()){ //30, 20, 10 --> 10, 20, 30
            temp.push(s.pop());
        }
        return temp;
    }

    //print
    void display(){
        Node temp = top;
        while(temp!=null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
/* Complexity
Operation   Time	Space
push()      O(1)	O(1)
peek()	    O(1)	O(1)
pop()	    O(1)	O(1)
isEmpty()   O(1)	O(1)
reverse()	O(n)	O(1)
reverse()	O(n)	O(n) ⭐⭐⭐⭐⭐
reverse()	O(n)	O(n) ⭐⭐⭐
display()	O(n)	O(1) ⭐⭐⭐⭐
*/
