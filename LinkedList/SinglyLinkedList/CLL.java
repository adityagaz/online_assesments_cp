package LinkedList.SinglyLinkedList;

public class CLL {
    private Node head;
    private Node tail;
    private int size = 0;

    public void insertAtFirst(int value) {
        //create a new box
        Node newNode = new Node(value);
        if(tail == null) {
            //it means we have an empty list because tail does not point to null in circular list
            tail = newNode;
            tail.next = tail;
            head = newNode;
            size++;
            //pointing to next
            return;
        }
        newNode.next = tail.next;
        tail.next = newNode;
        head = newNode;
        size++;
    }

    public void  insert(int index , int value) {
        if(index == 0) {
            insertAtFirst(value);
            return;
        }

        if(index >= size) {
            System.out.println("Index " + index + " out of bounds for size " + size);
            return;
        }

        if( index == size -1) {
            insertAtLast(value);
            return;
        }
        Node temp = tail.next;
        Node newNode = new Node(value);
        //you are at the head;
        for(int i  =0 ; i < index -1 ; i++ ){
            temp = temp.next;
        }
        //now you reached the node which is one index before where you want to update
        newNode.next = temp.next;
        temp.next = newNode;
        size+=1;

    }

    public void insertAtLast(int value) {
        if(size == 0) {
            //list is empty and adding at first or last means the same thing
            insertAtFirst(value);
            return;
        }
        Node newNode = new Node(value);

        newNode.next = tail.next;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    //deletion

    public void deleteAtFirst() {
        //if there is only one element then you would say that point the tail towards null and head also to null.
        if(size == 0 ) {
            System.out.println("Can't delete an element from a empty list");
            return;
        }
        if(size == 1) {
            tail = null;
            head = null;
            size--;
            return;
        }

        tail.next = tail.next.next;
        head = tail.next;
        size--;
    }

    public void deleteAtLast() {
        if(size <=1) {
            deleteAtFirst();
            return;
        }

        Node temp = tail.next;
        //temp is at head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        //now after the loop temp is at second last position
        temp.next = tail.next;
        //second last element points to head
        tail = temp;
        size--;
    }

    public void delete(int index) {
        if(index == 0) {
            deleteAtFirst();
            return ;
        }

        if(index == size -1 ){
            deleteAtLast();
            return;
        }

        if(index >= size ) {
            System.out.println("Index "+ index + " out of bounds for size " + size) ;
            return;
        }
        Node temp= tail.next;
        for(int i = 0 ; i < index -1 ; i++ ){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }


    public void display() {

        if(size == 0  ) {
            System.out.println("Cannot Display list with size 0");
            return;
        }

        Node temp = tail.next;

        //we want to run the loop once without checking the condition
        //because temp is now pointing to head therefore we will use do while loop
        //or we can just print the first item out of the loop then use the loop

        do  {
            System.out.print(temp.value + " -> ");
            temp= temp.next;

        } while(temp!= head);


        System.out.println("start");
    }

    private class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
        }
        Node(int value , Node next) {
            this.value = value;
            this.next = next;
        }
    }



}
