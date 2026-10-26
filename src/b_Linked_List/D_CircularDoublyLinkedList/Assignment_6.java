package b_Linked_List.D_CircularDoublyLinkedList;

public class Assignment_6 {

    public void assignment6() {
        CircularDoublyLinkedList cdll = new CircularDoublyLinkedList();
        cdll.insertAtFirst(5);
        cdll.display();
        cdll.insertAtLast(15);
        cdll.display();
        cdll.insertAfter(cdll.search(5), 10);
        cdll.display();
        cdll.deleteFirst();
        cdll.display();
        cdll.deleteLast();
        cdll.display();
        cdll.deleteNode(10);
        cdll.display();
    }
}

class CircularDoublyLinkedList{
    private Node head;

    class Node{
        Node next;
        Node prev;
        int data;

        public Node getPrev() {
            return prev;
        }
        public void setPrev(Node prev) {
            this.prev = prev;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
    }

    void insertAtFirst(int data){
        head = insertAtFirstOrLast(data);
    }

    void insertAtLast(int data){
        Node n = insertAtFirstOrLast(data);
        if(head == null)  head = n;
        else head.setPrev(n);
    }

    void insertAfter(Node t, int data){
        if(t != null){
            Node n = createNode(data);

            n.setNext(t.getNext());
            n.setPrev(t);
            t.getNext().setPrev(n);
            t.setNext(n);
        }
    }

    void deleteFirst(){
        if(!isEmpty()){
            if(head.getNext() == head) {
                head = null;
            } else {
                head.getPrev().setNext(head.getNext());
                head.getNext().setPrev(head.getPrev());
                head = head.getNext();
            }
        }
    }

    void deleteLast(){
        if(!isEmpty()){
            if(head.getNext() == head) {
                head = null;
            } else {
                head.getPrev().getPrev().setNext(head);
                head.setPrev(head.getPrev().getPrev());
            }
        }
    }

    void deleteNode(int data){
        Node t = search(data);
        if(t != null){
            if(head == t){
                deleteFirst();
            } else if(head.getPrev() == t){
                deleteLast();
            } else {
                t.getNext().setPrev(t.getPrev());
                t.getPrev().setNext(t.getNext());
            }
        }
    }

    Node search(int data){
        if(!isEmpty()){
            Node t = head;
            do{
                if(t.getData() == data) return t;
                t = t.getNext();
            } while(t != head);
        }
        return null;
    }

    private Node insertAtFirstOrLast(int data){
        Node n = createNode(data);
        if(head == null){
            n.setPrev(n);
            n.setNext(n);
        } else{
            n.setNext(head);
            n.setPrev(head.getPrev());
            head.getPrev().setNext(n);
            head.setPrev(n);
        }
        return n;
    }

    boolean isEmpty(){
        return head == null;
    }

    private Node createNode(int data){
        Node n = new Node();
        n.setData(data);
        return n;
    }

    void display(){
        if(isEmpty()){
            System.out.println("List is Empty...");
            return;
        }

        Node t=head;
        do{
            System.out.print(t.getData()+" ");
            t=t.getNext();
        }while(t!=head);
        System.out.println();
    }
}
