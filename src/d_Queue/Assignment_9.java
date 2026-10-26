package d_Queue;

public class Assignment_9 {
    static void main() {
        QueueUsingArray queue = new QueueUsingArray(5);
        System.out.println("queue is Underflow: "+ queue.isUnderflow());
        System.out.println("queue is Overflow: "+ queue.isOverflow());
        System.out.println("No of Elements: "+ queue.countItems());
        System.out.println("Front: "+ queue.getFront() + " & item: " + queue.viewFrontItem());
        System.out.println("Rear: "+ queue.getRear() + " & item: " + queue.viewRearItem());
        System.out.println();

        queue.enqueue(10);
        System.out.println("queue is Underflow: "+ queue.isUnderflow());
        System.out.println("queue is Overflow: "+ queue.isOverflow());
        System.out.println("No of Elements: "+ queue.countItems());
        System.out.println("Front: "+ queue.getFront() + " & item: " + queue.viewFrontItem());
        System.out.println("Rear: "+ queue.getRear() + " & item: " + queue.viewRearItem());
        System.out.println();

        queue.enqueue(20);
        System.out.println("queue is Underflow: "+ queue.isUnderflow());
        System.out.println("queue is Overflow: "+ queue.isOverflow());
        System.out.println("No of Elements: "+ queue.countItems());
        System.out.println("Front: "+ queue.getFront() + " & item: " + queue.viewFrontItem());
        System.out.println("Rear: "+ queue.getRear() + " & item: " + queue.viewRearItem());
        System.out.println();

        queue.enqueue(30);
        System.out.println("queue is Underflow: "+ queue.isUnderflow());
        System.out.println("queue is Overflow: "+ queue.isOverflow());
        System.out.println("No of Elements: "+ queue.countItems());
        System.out.println("Front: "+ queue.getFront() + " & item: " + queue.viewFrontItem());
        System.out.println("Rear: "+ queue.getRear() + " & item: " + queue.viewRearItem());
        System.out.println();

        queue.enqueue(40);
        System.out.println("queue is Underflow: "+ queue.isUnderflow());
        System.out.println("queue is Overflow: "+ queue.isOverflow());
        System.out.println("No of Elements: "+ queue.countItems());
        System.out.println("Front: "+ queue.getFront() + " & item: " + queue.viewFrontItem());
        System.out.println("Rear: "+ queue.getRear() + " & item: " + queue.viewRearItem());
        System.out.println();

        queue.enqueue(50);
        System.out.println("queue is Underflow: "+ queue.isUnderflow());
        System.out.println("queue is Overflow: "+ queue.isOverflow());
        System.out.println("No of Elements: "+ queue.countItems());
        System.out.println("Front: "+ queue.getFront() + " & item: " + queue.viewFrontItem());
        System.out.println("Rear: "+ queue.getRear() + " & item: " + queue.viewRearItem());
        System.out.println();

        System.out.println("Deleted element: "+ queue.dequeue());
        System.out.println("queue is Underflow: "+ queue.isUnderflow());
        System.out.println("queue is Overflow: "+ queue.isOverflow());
        System.out.println("No of Elements: "+ queue.countItems());
        System.out.println("Front: "+ queue.getFront() + " & item: " + queue.viewFrontItem());
        System.out.println("Rear: "+ queue.getRear() + " & item: " + queue.viewRearItem());
        System.out.println();

        queue.enqueue(60);
        System.out.println("queue is Underflow: "+ queue.isUnderflow());
        System.out.println("queue is Overflow: "+ queue.isOverflow());
        System.out.println("No of Elements: "+ queue.countItems());
        System.out.println("Front: "+ queue.getFront() + " & item: " + queue.viewFrontItem());
        System.out.println("Rear: "+ queue.getRear() + " & item: " + queue.viewRearItem());
        System.out.println();
    }
}

class QueueUsingArray {
    int front, rear;
    int[] queue;

    //parameterized constructor
    QueueUsingArray(int size){
        front = -1;
        rear = -1;
        queue = new int[size];
    }

    //insert element into queue
    void enqueue(int data){
        if(isOverflow()) {
            System.out.println("Queue is Overflow...");
            return;
        } else if(isUnderflow()){ //empty queue
            front = rear = 0;
        } else if(rear+1 == queue.length){
            rear = 0;
        } else {
            rear++;
        }
        queue[rear] = data;
    }

    //view front item
    int viewFrontItem(){
        if(isUnderflow()){
            System.out.println("Queue is Underflow");
            return -1;
        } else {
            return queue[front];
        }
    }
    //view rear item
    int viewRearItem() {
        if(isUnderflow()) {
            System.out.println("Queue is Underflow...");
            return -1;
        } else {
            return queue[rear];
        }
    }

    //delete
    int dequeue(){
        int deletedItem = -1;
        if(isUnderflow()){
            System.out.println("Queue is Underflow...");
        } else if (front == rear){
            deletedItem = queue[front];
            front = rear = -1;
        } else if(front == queue.length-1) {
            deletedItem = queue[front];
            front = 0;
        } else {
            deletedItem = queue[front];
            front++;
        }
        return deletedItem;
    }

    //check queue is Empty or not
    boolean isUnderflow(){
        return rear == -1;
    }
    //check queue is Full or not
    boolean isOverflow(){
        return rear == queue.length-1 && front == 0 || rear+1 == front ;
    }

    //count number of elements present in the queue
    int countItems() {
        if(isUnderflow()){
            return 0;
        } else if(rear >= front){
            return rear - front + 1;
        } else {
            return queue.length - (front - rear) + 1;
        }
    }

    //get Front index
    int getFront(){
        return front;
    }

    //get Rear index
    int getRear() {
        return rear;
    }
}
