package b_Linked_List.A_SinglyLinkedList;

public class Assignment_3 {
    public void assignment3() {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtFirst(5);
        sll.display();
        sll.insertAfter(sll.search(5), 10);
        sll.display();
        sll.insertAtLast(15);
        sll.display();
        sll.deleteFirst();
        sll.display();
        sll.deleteNode(10);
        sll.display();
        sll.deleteLast();
        sll.display();
    }
}

class SinglyLinkedList
{
    private Node head;

    private class Node {
        private int data;
        private Node next;

        public int getData(){
            return data;
        }
        public void setData(int data){
            this.data = data;
        }

        public Node getNext(){
            return next;
        }
        public void setNext(Node next){
            this.next = next;
        }
    }

    public void insertAtFirst(int data) {
        Node newNode = createNode(data);
        newNode.setNext(head);
        head = newNode;
    }

    public void insertAtLast(int data) {
        if(!isEmpty()){
            Node newNode = createNode(data);
            Node t = head;
            while(t.getNext() != null){
                t = t.getNext();
            }
            t.setNext(newNode);
        } else{
            insertAtFirst(data);
        }
    }

    public Node search(int data){
        if(!isEmpty()){
            Node t = head;
            while(t != null){
                if(t.getData() == data){
                    return t;
                }
                t = t.getNext();
            }
        }
        return null;
    }

    public void insertAfter(Node node, int data){
        if(node != null){
            Node newNode = createNode(data);
            newNode.setNext(node.getNext());
            node.setNext(newNode);
        }
    }

    public void deleteFirst(){
        if(!isEmpty()){
            head = head.getNext();
        }
    }

    public void deleteLast(){
        if(!isEmpty()){
            if(head.getNext() == null){
                head = null;
            } else {
                Node t = head;
                while(t.getNext().getNext() != null){
                    t = t.getNext();
                }
                t.setNext(null);
            }
        }
    }

    public void deleteNode(int data) {
        if(!isEmpty()){
            if(head.getData() == data){
                deleteFirst();
            } else {
                Node t = head;
                while(t.getNext() != null){
                    if(t.getNext().getData() == data){
                        t.setNext(t.getNext().getNext());
                        return;
                    }
                    t = t.getNext();
                }
            }
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

    private Node createNode(int data){
        Node newNode = new Node();
        newNode.setData(data);
        return newNode;
    }

    public void display() {
        if (!isEmpty()) {
            Node t = head;
            while (t != null) {
                System.out.print(t.getData() + " ");
                t = t.getNext();
            }
            System.out.println();
        }
    }
}


