package LinkedList.SinglyLinkedList;

public class ReorderList {

    public static void main (String [] args) {

        LL list = new LL();

        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(4);
        list.insertAtLast(5);
        list.insertAtLast(6);
        list.insertAtLast(7);
        list.insertAtLast(8);

        LL.Node head = list.head;


        list.display();
//        revmiddle(head);
        LL.Node newHead = reverseRecursion(head);
        list.display(newHead);


    }




    static LL.Node reverseRecursion(LL.Node head) {

        if( head.next== null ) {
            return head;
        }

        LL.Node temp = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;


        return temp ;



    }


    static void revmiddle(LL.Node head ) {
        int count = 0;

        LL.Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        count = count /2;
        LL.Node t = head;
        while(count != 0) {
            t = t.next;
            count--;
        }
        //reverse the linkedlist
        LL.Node last = reverse(t);
        LL.Node start = head;
        while(last.next!=null) {

            LL.Node agla = start.next;
            LL.Node pichla = last.next;

            start.next = last;

            start = agla;
            last.next = agla;

            last = pichla;

        }



    }
    static LL.Node reverse(LL.Node head) {

        LL.Node temp = head;
        LL.Node prev = null;

        while(temp!= null) {
            LL.Node nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
        }

//        while(prev!=null) {
//            System.out.print(prev.value + " ->" );
//            prev = prev.next;
//        }
//        System.out.print("END");

        return prev;
    }

}
