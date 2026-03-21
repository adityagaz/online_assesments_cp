package LinkedList.SinglyLinkedList;

import LinkedList.SinglyLinkedList.DoublyLinkedList.DL;

public class Main {
    public static void main (String  [] args) {
        LL list = new LL();
//        list.insertAtFirst(3);
//        list.insertAtFirst(4);
//        list.insertAtFirst(5);
//        list.insertAtFirst(6);
//        list.display();
//
//        list.reverse(list.getFirst(), null);
        int [] arr = {25, 73, 19, 49, 4, 50, 70, 4, 57, 25, 94, 5, 19, 25, 75, 15, 46, 81, 68, 22, 50, 76, 6, 6, 71, 67, 47, 60, 49, 46, 75, 81, 74, 73, 30, 57, 66, 89, 38, 5, 3, 85, 39, 30, 83, 59, 71, 80, 28, 91, 84, 84, 50, 28, 8, 28, 74, 97, 7, 36, 27, 60, 61,
                31, 20, 95, 96, 19, 73, 89, 82, 67, 80, 90, 57, 20, 92, 24, 70, 38};
        int m = 32;
        int n =  4;

        for( int i = 0 ; i < arr.length ; i++) {
            list.insertAtLast(arr[i]);
        }
        list.display();

        LL.Node head = list.head;
        list.display();
//        list.insertAtLast(7);
//        list.display();
//        //printing the first element
//        System.out.println(list.peek());
//
//        //getting the last element
//        System.out.println(list.lastElement());
//
//        for (int i = 0 ; i < 10 ; i++ ){
//            list.insertAtLast(i);
//        }
//
//        list.display();

//        list.insert(0 , 239);
//        list.insert(1 , 434);
//        list.insert(2, 512);
//        list.insert(1, 20);
//        list.insert(2, 10);
//        list.insert(5, 50);
//
//        //cool
//
//        list.display();
//        System.out.println(list.size());

//        DL doublylist  = new DL();
//        doublylist.insertAtFirst(59);
//        doublylist.insertAtFirst(12);
//        doublylist.insertAtFirst(13);
//        doublylist.insertAtLast(71);
//        doublylist.insert(doublylist.size() -1  , 343);

//        doublylist.deleteAtLast();
//        doublylist.deleteAtLast();
//        doublylist.deleteAtLast();
//        doublylist.deleteAtLast();
//        doublylist.deleteAtLast();
//

//        doublylist.delete(0);
//        doublylist.display();
//        doublylist.displayRev();



//        CLL clist = new CLL();
//
//        clist.insertAtFirst(23);
//        clist.insertAtFirst(33);
//        clist.insertAtFirst(23);
//        clist.insertAtFirst(43);
//        clist.insertAtFirst(53);

//
//        clist.insertAtLast(90);
//        clist.insertAtLast(90);
//        clist.insert( 0 , 55);
//        clist.insert(clist.size() -1 , 99);
//        clist.insert( 1 , 101);
//        clist.insert( 1, 101);
//        clist.insert( 0, 100);
//        clist.insert( 2, 102);

//        clist.delete(0);
//
//        //working perfect
//        clist.display();

    }
//
}
