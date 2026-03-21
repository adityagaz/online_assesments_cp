package LinkedList.SinglyLinkedList.DoublyLinkedList;

public class DL {
    private int size = 0;
    private Node head;
    private Node tail;


    //insertion at firstIndex

    public void insertAtFirst(int value ) {
        Node newNode = new Node(value);
        newNode.next = head;
        newNode.prev = null;
        //if the newNode is the first one in the linked list then we need to add a check

        if(head != null) {
            head.prev = newNode;
        }
        head = newNode;
        size++;

    }


    public void display() {
        Node temp = head;

        while(temp != null)
        {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("end");
    }

    public void displayRev() {
        if(size() == 0) {
            System.out.println("Cannot print reverse for zero elements");
            return;
        }
        Node temp = head;

        //go to last element and then come to previous
        while(temp.next != null) {
            temp = temp.next;
        }
        //reached the end
        while(temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.prev;
        }
        System.out.println("start");
    }



    public void insertAtLast(int value) {
        Node newNode = new Node(value);
        if(size == 0 ) {
            insertAtFirst(value);
            return;
        }
        Node temp = head;

        while(temp.next != null){
            temp= temp.next;
        }

        newNode.prev = temp;
        temp.next = newNode;
        newNode.next = null;
        size++;
    }

    public int size () {
        int count = 0;
        Node temp = head;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insert(int index , int value) {
        Node newNode = new Node(value);
        Node temp = head;
        if(index >= size ()) {
            System.out.println("Index "+ index + " out of bounds for size " + size());
            return;
        }
        if(temp == null || index == size() -1 ){
            insertAtLast(value);
            return;
        }
        for( int i = 0 ; i < index -1 ; i++ ) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next.prev = newNode;
        temp.next = newNode;
        newNode.prev = temp;
        size++;

    }

    public void deleteAtFirst() {
        if(size == 0 ) {
            System.out.println("Cannot delete an element with size 0");
            return;
        }
        head = head.next;
        if(head.prev != null ){
            head.prev = null;
        }
        size--;
    }

    public void deleteAtLast() {
        Node temp = head;
        if(size <= 1 ){
            deleteAtFirst();
            return;
        }
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
        size--;

    }

    public void delete(int index) {

        if(index >= size()){
            System.out.println("Index "+ index + " out of bounds for " + size());
            return;
        }
        if(index == size() - 1 ){
            deleteAtLast();
            return;
        }
        if(index == 0) {
            deleteAtFirst();
        }
        if(size() < 1) {
            deleteAtLast();
            return;
        }
        Node temp = head;
        for( int i  = 0 ; i < index -1 ; i++ ) {
            temp= temp.next;
        }
        temp.next = temp.next.next;
        temp.next.prev = temp;
        size--;
    }

    private class Node {
        int value;
        Node next;
        Node prev;

        Node() {
            int value = 0;
            next = null;
            prev = null;
        }
        Node(int value) {
            this.value = value;
        }
        Node (int value , Node next) {
            this.value = value;
            this.next = next;
        }
        Node (int value , Node next , Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
