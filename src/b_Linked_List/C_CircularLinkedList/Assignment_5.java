package b_Linked_List.C_CircularLinkedList;

public class Assignment_5 {
    public void assignment5(){
        CircularLinkedList s1 = new CircularLinkedList();
        s1.insertAtFirst(10);
        s1.insertAtLast(20);
        s1.insertAfter(s1.search(20), 30);
        s1.printNode();
        s1.deleteFirst();
        s1.printNode();
        s1.deleteLast();
        s1.printNode();
        s1.deleteNode(20);
    }
}

class CircularLinkedList {
    private Node tail;

    private class Node {
        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    void insertAtFirst(int data){
        Node newNode = createNode(data);
        if(isEmpty()){
            newNode.setNext(newNode);
            tail = newNode;
        } else {
            newNode.setNext(tail.getNext());
            tail.setNext(newNode);
        }
    }

    void insertAtLast(int data) {
        insertAtFirst(data);
        tail = tail.getNext();
    }

    void insertAfter(Node node, int data){
        if(node == null) {
            return;
        }
        Node newNode = createNode(data);
        newNode.setNext(node.getNext());
        node.setNext(newNode);
        if(node == tail){
            tail =  newNode;
        }
    }

    void deleteFirst(){
        if(!isEmpty()){
            if(tail.getNext() == tail){
                tail = null;
            } else {
                tail.setNext(tail.getNext().getNext());
            }
        }
    }

    void deleteLast() {
        if(!isEmpty()){
            if(tail.getNext() == tail){
                tail = null;
            } else {
                Node t = tail.getNext();
                while (t.getNext() != tail) {
                    t = t.getNext();
                }
                t.setNext(tail.getNext());
                tail = t;
            }
        }
    }

    void deleteNode(int data){
        if(isEmpty()){
            return;
        }

        Node current = tail.getNext();
        Node prev = tail;

        do{
            if(current.getData() == data){
                if(current == tail){
                    deleteLast();
                } else {
                    prev.setNext(current.getNext());
                }
                return;
            }
            prev = current;
            current = current.getNext();
        } while (current != tail.getNext());
    }

    void deleteNode2(int data) {
        Node t = search(data);
        if(t != null){
            if(tail.getNext() == tail){
                tail = null;
            } else{
                if(t == tail){
                    deleteLast();
                } else {
                    Node temp = tail.getNext();
                    while(temp.getNext() != t){
                        temp = temp.getNext();
                    }
                    temp.setNext(t.getNext());
                }
            }
        }
    }

    Node search(int data){
        if (isEmpty()) {
            return null;
        }
        Node t = tail.getNext();
        do {
            if (t.getData() == data) {
                return t;
            }
            t = t.getNext();
        }while (t != tail.getNext());
        return null;
    }

    private Node createNode(int data) {
        Node newNode = new Node();
        newNode.setData(data);
        newNode.setNext(null);
        return newNode;
    }

    boolean isEmpty() {
        return tail == null;
    }

    void printNode(){
        Node t = tail.getNext();
         do {
            System.out.print(t.getData() + " ");
            t = t.getNext();
        }while(t != tail.getNext());
        System.out.println();
    }
}
