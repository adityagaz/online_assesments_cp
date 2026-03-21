package LinkedList.SinglyLinkedList;
import java.util.*;
public class reverseBetween {

    public static void main (String [] args ) {
        LL list = new LL();
//
//        list.insertAtLast(1);
//        list.insertAtLast(2);
        list.insertAtLast(3);
//        list.insertAtLast(4);
        list.insertAtLast(5);

        list.display();
        //after sorting
        int left = 1;
        int right = 2;

        LL.Node ans = reverseBetween(list.head , left , right);

        list.display(ans);


    }
    public static LL.Node reverseBetween(LL.Node head, int left, int right) {
        LL.Node dummy = new LL.Node(0);
        dummy.next = head;
        LL.Node temp = dummy;


        //go till the left node
        for(int i= 1 ; i <left && temp!=null ; i++) {
                temp = temp.next;
        }
        //now temp is at the first half the node just before the one which is to be reversed

        LL.Node leftSide = temp;
        LL.Node prev = reverse(temp.next, right - left + 1);
        leftSide.next = prev;
        return dummy.next;
    }

    static LL.Node reverse(LL.Node head , int count){

        LL.Node toConnect = head;
        LL.Node prev = null;
        LL.Node temp= head;
        while(temp!=null && count >0) {
            LL.Node nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
            count--;
        }
        //connect the remaining to the start of the list
        if(toConnect!=null){
            toConnect.next = temp;
        }

        return prev;
    }
}
