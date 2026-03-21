package Trees;
import java.util.Scanner;
public class BST extends BinaryTree {
    private Scanner s ;

    @Override
    public void populate() {
        s = new Scanner(System.in);
        System.out.println("Enter the value of the root node");
        int value = s.nextInt();
        root = new Node(value);
        populateTree(root , s);
    }

    public void populateTree(Node node , Scanner s) {
        while(true){
            System.out.println("Enter the next node's value ");
            int value = s.nextInt();
            if(value == -1) break;
            insert(node , value);
        }
    }

    private void insert(Node node , int value) {
        if(value  < node.value) {
            if(node.left == null) {
                node.left = new Node(value);
            }
            else {
                insert(node.left , value);
            }
        }
        else {
            if(node.right== null ) {
                node.right = new Node(value);
            }
            else {
                insert(node.right , value);
            }
        }
    }


}
