package d_Queue;

public class Assignment_10 {
}

class QueueUsingLinkedList {
    Node front, rear;

    QueueUsingLinkedList(){
        front = rear = null;
    }

    //insert
    void enqueue(int data) {
        Node n = new Node(data);
        if(underflow()){
//            n.next = null;
            front = n;
        } else{
            rear.next = n;
        }
        rear = n;
    }

    //view rear element
    int viewRearElement() {
        if(!underflow()){
            return rear.data;
        }
        System.out.println("Queue is Underflow...");
        return -1;
    }

    //view front element
    int viewFrontElement() {
        if(!underflow()) {
            return front.data;
        }
        System.out.println("Queue is Underfow...");
        return -1;
    }

    //delete the front element
    int dequeue() {
        int f = -1;
        if(underflow()) {
            System.out.println("Queue is Underflow...");
            return f;
        } else if(rear == front) {
            f = front.data;
          rear = front = null;
        } else {
            f = front.data;
            front = front.next;
        }
        return f;
    }
    //check Queue is empty or not
    boolean underflow() {
        return rear == null;
    }
    //count number of elements present in the queue
}
class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
    }
}
