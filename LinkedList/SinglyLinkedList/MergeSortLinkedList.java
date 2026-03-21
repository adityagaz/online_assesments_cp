package LinkedList.SinglyLinkedList;
import  java.util.*;
public class MergeSortLinkedList {

    public static void main (String [] args ) {
        LL list = new LL();

        list.insertAtLast(5);
        list.insertAtLast(4);
        list.insertAtLast(3);
        list.insertAtLast(2);
        list.insertAtLast(1);

        list.display();
        //after sorting
        LL.Node sortedHead =  mergeSort(list.head);
        list.display(sortedHead);



    }

    static LL.Node findMid(LL.Node head) {

        LL.Node slow = head;
        LL.Node fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static LL.Node mergeSort(LL.Node head){

        if(head ==null || head.next == null) {
            //if we have an empty linked list or a linked list with one element so it is sorted
            return head;
        }

        LL.Node mid = findMid(head);


        LL.Node left= head;
        LL.Node right = mid.next;
        mid.next = null; // important step
        //break the linked list... this step is important

        left = mergeSort(left);
        right = mergeSort(right);

        return mergTwoLinkedLists(left , right);
    }

    static LL.Node mergTwoLinkedLists(LL.Node head , LL.Node end) {

        //create a dummy list to make the sorted list

        LL.Node dummy = new LL.Node();
        LL.Node h1 = head;
        LL.Node h2 = end;
        LL.Node temp = dummy;

        while(h1!=null && h2 !=null) {
            if(h1.value  < h2.value  ) {
                temp.next = h1;
                h1 = h1.next;
            }
            else{
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }

        //if anyone of that finishes early then we just need to handle
        if(h1 != null) {
            //it means end became null so point the remaining to the head
            temp.next = h1;
        }
        if(h2!= null ) {
            temp.next = h2;
        }

        return dummy.next;
    }
 }
