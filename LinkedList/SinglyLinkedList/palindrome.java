package LinkedList.SinglyLinkedList;

public class palindrome {
    public static void main(String [] args){
            LL list = new LL();

            list.insertAtLast(1);
            list.insertAtLast(2);
            list.insertAtLast(3);
            list.insertAtLast(4);
            list.insertAtLast(5);

            list.display();
//        list.display(oddEven( list.head));

        list.display(helper( list.head , 2));


//            list.display(rotate( list.head, 3));

            //after sorting

//        System.out.println(isPalindrome(list.head , list) );
//        list.display();








    }
    //leetcode 25 hard

    public static LL.Node helper (LL.Node head , int k ) {
        LL.Node temp = head;
        int size = 0;
        while(temp!=null) {
            size++;temp= temp.next;
        }

        int no_of_ops = size / k ;
       return  reverseKGroups(head , no_of_ops , k);
    }

    public static LL.Node reverseKGroups(LL.Node head , int count , int k) {
        if(count == 0) {
            return head;
        }
        int next_count = count -1;
        LL.Node temp = head;
        int no_of_el = k-1;
        while(no_of_el  >  0) {
            temp = temp.next;
            no_of_el--;
        }
        LL.Node to_pass = temp.next;temp.next = null;


        LL.Node to_connect = reverseKGroups(to_pass , next_count , k);

        LL.Node start = head;
        LL.Node prev = reverse(start);
        start.next = to_connect;
        return prev;
    }

    //leetcode  328 odd and even linked list
    public static LL.Node oddEven(LL.Node head){
        //first node is odd and second node is even ...
        //keep all odd nodes first and then all the even nodes

            if(head == null) {
                return null;
            }

            LL.Node temp = head;
            int size = 0;
            while(temp != null) {
                size++;temp = temp.next;
            }

            LL.Node start = head;
            LL.Node even_start = head.next;

            LL.Node even_i = head.next;

            for (int i = 0 ; i  < (size +1 )/2 -1  ; i++) {
                start.next = start.next.next;
                start = start.next;
                even_i.next = start.next;
                even_i = even_i.next;
            }
            start.next = even_start;
            return head;
    }

    public static LL.Node rotate(LL.Node head, int k ) {
        if(head == null ){
            return null;
        }

        //calculate length of the list first
        LL.Node temp = head;
        int c = 0;
        while(temp != null ) {
            c++;temp = temp.next;
        }
        k = k % c;
        if(k <= 0 ){
            return head;
        }
        LL.Node toConnect = head;
        LL.Node ref = head;
        for (int i  =0 ; i <  c -k -1 ; i++) {
            ref = ref.next;
        }
        LL.Node newHead = ref.next;
        ref.next = null;
        LL.Node it = newHead;
        while(it.next!=null) {
            it = it.next;
        }
        it.next = head;
        return (newHead == null  ? head : newHead) ;

    }

    public static boolean isPalindrome(LL.Node head ,LL list) {
        LL.Node middle = mid(head);
        LL.Node start = head;
        LL.Node end = reverse(middle);
        list.display(end);

        while(start!=null && end!=null) {
            if(start.value != end.value){
                return false;
            }
            start = start.next;
            end = end.next;
        }
        return true;
    }
    static LL.Node reverse(LL.Node head ) {
        LL.Node prev =null;
        LL.Node temp = head;

        while(temp!=null) {
            LL.Node nxt = temp.next;
            temp.next = prev;
            prev = temp;
            temp = nxt;
        }

        return prev;
    }
    static LL.Node mid(LL.Node head ) {
        if(head == null ) {
            return head;
        }
        LL.Node slow = head;
        LL.Node fast = head.next;

        while(fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
