package LinkedList.SinglyLinkedList;

public class LL {
    public Node head;
    private Node tail;
    private int size;

    public Node getFirst(){
        return head;
    }

    public LL() {
        this.size = 0;
    }

    public void insertAtFirst(int value) {

        /*
        now we have two scenarios
        imagine we have empty linked list
        so head is also null and tail is also null
        so we will create a new node assign the incoming value to it
        and then next pointer to node will point to head and after that head will point to our
       node , in this way we changed some arrows and now it is being inserted at our first element


       now if tail is also pointing to null then it means we are inserting to the empty ll
       so we will update the tail to point to head and finally make the size increment.
         */
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if(tail == null ) {
            tail = head;
        }
        size++;
    }


    public void insertAtLast(int value) {
        Node newNode = new Node(value);
        Node temp = head;

        //if the list is empty
        if(temp == null) {
            insertAtFirst(value);
        }
        //if not empty
       else{
            while(temp.next != null ) {
                temp = temp.next;
            }


            temp.next = newNode;

            size++;
        }
       tail = newNode;

    }

    public void display() {
        //donot take the head and use it directly because it will change the structure of
        //the linked list
        //take an another variable temp and use it to traverse

        Node  temp = head;

        while(temp != null  ) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public void display(Node head) {
        //donot take the head and use it directly because it will change the structure of
        //the linked list
        //take an another variable temp and use it to traverse

        Node  temp = head;

        while(temp != null  ) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public int peek() {
        //look at the first element of the linked list
        return head.value;
    }

    public int lastElement() {
        return tail.value;
    }

    public int size() {
        int count = 0 ;
        Node temp = head;
        while(temp != null  ) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void  insert(int index , int value) {
        if(index >= size()){
            System.out.println("Index " + index + " out of bounds for  length " + size());
            return;
        }
        Node NewNode = new Node(value);
        Node temp = head;
        for (int i =0 ; i < index -1  ;i++) {
            temp = temp.next;
        }
        if(temp == null) {
            //you are requesting the insertion at the first element or the list is empty
             insertAtLast(value);
        }
        else{
            NewNode.next = temp.next;
            temp.next = NewNode;
            size++;
        }

    }

    //deleting elements

    public void deleteFirst() {
        if(size() == 0) {
            System.out.println("Can't delete an empty list");
            return;
        }
        //deleting is easy from first just shift head pointer by one
        head = head.next;
        if(head == null ) {
            tail = head;
        }
        size--;
    }

    public void deleteLast() {
        if(size () == 0) {
            System.out.println("Can't delete an empty list");
            return;
        }
        if(size() == 1) {
            deleteFirst();
            return;
        }
        Node temp = head;
        while(temp.next.next !=null) {
            //this stops at the second last element
            temp = temp.next;
        }
        temp.next = null;
        tail=temp;
        //just assign the second last node to null
        size--;
    }

    public void delete(int index){
        if(index >= size() || index < 0) {
            System.out.println("Index " + index + " out of bounds for " + size());
            return;
        }
        //delete at particular index
        if(index == size() -1) {
            deleteLast();
            return;
        }
        if(index == 0 ) {
            deleteFirst();
            return;
        }
        Node temp = head;
        for(int i =0 ; i < index -1 ; i++ ) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;

    }

    public Node find(int value) {
        //this function returns where the node where the value is (first appearence) if found
        Node temp = head;

        while(temp != null) {
            if(temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }

        //if nothing found return null
        return null;

    }

    public void reverse(Node start , Node prev) {
        //recursive approach
        if(start == null){
            return ;
        }
        Node temp = start;
        Node prev_t = prev;
        if(temp.next == null){
            head = temp;
        }
        reverse(temp.next , temp);
        temp.next = prev_t;

    }


    public static class Node {
        int value;
        public Node next; //default value is null

        Node(int value) {
            this.value = value;
        }
        Node(int value , Node next ) {
            this.value  = value;
            this.next = next;
        }

        public Node() {

        }
    }

}
