package LinkedList.SinglyLinkedList;
import java.util.*;
public class DetectCycle2 {
    public static void main (String [] args) {
        LL list = new  LL();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(4);
        list.insertAtLast(5);

        LL.Node head = list.head;

        LL.Node it = head;
        while(it.next !=null) {
            it= it.next;
        }
        LL.Node hah = head.next;
        it.next = hah;


        System.out.println(detectCycle(list.head).value);
        System.out.println(solve(list.head));

    }

    public LL.Node sortList(LL.Node head) {

        LL.Node temp = head;

        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }

        for (int i = 0; i < count; i++) {
            LL.Node begin = head;
            while (begin.next != null) {
                if (begin.value > begin.next.value) {
                    int t = begin.next.value;
                    begin.next.value = begin.value;
                    begin.value = t;
                }
                begin = begin.next;
            }
        }
        return head;
    }

        static int solve(LL.Node root){
        // return -1 if no loop exists else return length of the loop

        LL.Node fast = root;
        LL.Node slow = root;

        int len= 0;

        while(fast.next != null && fast!=null) {

            fast = fast.next.next;
            slow=slow.next;

            if(fast==slow) {
                LL.Node current = fast;
                slow = slow.next;
                len++;
                while(slow!=current) {
                    len++;
                    slow = slow.next;
                }
                return len;

            }


        }

        return -1;

    }
    
    


    public static LL.Node detectCycle(LL.Node head) {
        LL.Node temp = head;
        HashMap <LL.Node , Integer> map = new HashMap<>();

        while(temp!=null) {
            if(map.containsKey(temp)) {
                return temp;
            }
            else{
                map.put(temp, temp.value);
            }
            temp = temp.next;
        }
        return null;

    }
    
    
    
}
