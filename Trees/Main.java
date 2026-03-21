package Trees;

import java.util.Scanner;

public class Main {
     public static void main (String [] args) throws Exception {
//         BinaryTree tree = new BinaryTree();

//         tree.populate(s);
////         tree.display();
//         tree.inOrder();
//         tree.preOrder();

         BST bst = new BST();
         bst.populate();
         bst.inOrder();
         bst.preOrder();
         bst.postOrder();
     }
}
