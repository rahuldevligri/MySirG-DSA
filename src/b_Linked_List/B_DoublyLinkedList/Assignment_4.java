package b_Linked_List.B_DoublyLinkedList;

public class Assignment_4 {
    public void assignment4() {
        DoublyLinkedList s1 = new DoublyLinkedList();
        s1.insertAtBeginning(10);
        s1.insetAtLast(20);
        s1.insetAtLast(30);
        s1.insertAfter(25, s1.search(20));
        s1.printList();
        s1.deleteFirstNode();
        s1.printList();
    }
}
class DoublyLinkedList {
    private Node head;

    class Node {
        int data;
        Node next;
        Node prev;

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

    void insertAtBeginning(int data) {
        Node newNode = createNode(data);
        newNode.setNext(head);
        if(!isEmpty()){
            head.setPrev(newNode);
        }
        head = newNode;
    }

    void insetAtLast(int data) {
        Node newNode = createNode(data);
        if(isEmpty()){
            head = newNode;
        } else {
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            newNode.setPrev(temp);
            temp.setNext(newNode);
        }
    }

    void insertAfter(int data, Node node){
        if(node != null){
            Node newNode = createNode(data);
            newNode.setNext(node.getNext());
            newNode.setPrev(node);

            if(node.getNext() != null){
                node.getNext().setPrev(newNode);
            }
            node.setNext(newNode);
        }
    }

    void deleteFirstNode() {
        if(isEmpty()){
            System.out.println("List is empty...");
            return;
        }
        head = head.getNext();
        if(head != null){
            head.setPrev(null);
        }
    }

    void deleteFirstNode2(){
        if(!isEmpty()){
            if(head.getNext()==null){
                head = null;
            } else {
                head.getNext().setPrev(null);
                head = head.getNext();
            }
        }
    }

    void deleteLastNode(){
        if(!isEmpty()){
            if (head.getNext() == null){
                head = null;
            } else {
                Node temp = head;
                while(temp.getNext().getNext() != null){
                    temp = temp.getNext();
                }
                temp.setNext(null);
            }
        }
    }

    void deleteNode(int data) {//⭐⭐⭐⭐☆
        Node node = search(data);
        if(node != null) {
            if(node == head){
                deleteFirstNode();
                return;
            } else if(node.getNext() == null){      // last node
                node.getPrev().setNext(null);
                return;
            } else {
                node.getPrev().setNext(node.getNext());
                node.getNext().setPrev(node.getPrev());
            }
        }
    }

    void deleteNode2(int data){ //⭐⭐⭐⭐⭐
        Node t = search(data);
        if(t != null){
            if(head == t){
                deleteFirstNode();
            } else {
                Node temp = t.getPrev();
                if(t.getNext() != null){
                    t.getNext().setPrev(temp);
                }
                temp.setNext(t.getNext());
            }
        }
    }

    Node search(int data) {
        Node temp = head;
        while(temp != null) {
            if(temp.getData() == data){
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }

    Node createNode(int data){
        Node newNode = new Node();
        newNode.setData(data);
        newNode.setNext(null);
        newNode.setPrev(null);
        return newNode;
    }

    boolean isEmpty(){
        return head == null;
    }

    public void printList(){
        Node t = head;
        while(t != null){
            System.out.print(t.getData() + " ");
            t=t.getNext();
        }
        System.out.println();
    }
}
