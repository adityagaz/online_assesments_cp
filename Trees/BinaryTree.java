package Trees;
import java.util.Scanner;
public abstract class BinaryTree {
    //write what all is there in a node of a binary tree
    public static Node root;
    public static class Node {
        protected int value;
        protected Node left;
        protected Node right;
        public Node(int value ) {
            this.value = value;
        }
        public Node() {
        }
    }
    public void populate(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of root node");
        int value = s.nextInt();
        root = new Node(value);
        populateTree(s , root);
        System.out.println("Tree Building Finished");
    }
    private void populateTree(Scanner s , Node node ) {
        System.out.println(" Do you want to enter left of " + node.value ) ;
        boolean left = s.nextBoolean();
        if(left ) {
            System.out.println("Enter the value of the left of this node");
            int leftValue = s.nextInt();
            node.left = new Node(leftValue);
            populateTree(s , node.left);
        }
        System.out.println("do you want to enter the right of " + node.value);
        boolean right = s.nextBoolean();
        if(right) {
            System.out.println("Enter the value of the right of this node");
            int rightValue = s.nextInt();
            node.right = new Node(rightValue);
            populateTree(s , node.right);
        }
    }
    public void display() {
        display(root);
    }
    private void display(Node node ) {
        if(node == null) {
            return;
        }
        System.out.print("\t\t " + node.value +  " ");
        display(node.left);
        display(node.right);
    }


    public void inOrder() {
        displayInorder(root);
    }

//    public abstract void populate();

    private void displayInorder(Node node) {
        //inorder == > LEFT-->ROOT-->RIGHT (ROOT IS "IN" so inorder)

        if(node == null ) {
            return;
        }
        displayInorder(node.left);
        System.out.println(node.value);//left printed
        displayInorder(node.right);

    }

    public void preOrder() throws Exception {
        displayPreorder(root);
    }

    private void displayPreorder( Node node) throws Exception {
        //PreOrder == > ROOT-->LEFT-->RIGHT (ROOT IS "IN" so inorder)


        if(node == null) {
            return;
        }
        System.out.println(node.value);//left printed
        displayInorder(node.left);
        displayInorder(node.right);
    }

    public void postOrder() {

        displayPostOrder(root);
    }

    private void displayPostOrder(Node node) {
        if(node == null  ) {
            return;
        }
        displayPostOrder(node.left);
        displayPostOrder(node.right);
        System.out.println(node.value);
    }

}
