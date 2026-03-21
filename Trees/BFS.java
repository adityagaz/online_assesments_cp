package Trees;
import java.util.*;



public class BFS {

    static class TreeNode <E> {
        TreeNode<E> left;
        TreeNode<E> right;
        E data;

        public TreeNode ( E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public ArrayList<Integer> bfs(TreeNode<Integer> root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode<Integer> node = q.poll();
            list.add(node.data);
            if(node.left != null) {
                q.offer(node.left);
            }
            if(node.right != null) {
                q.offer(node.right);
            }
        }
        return list;
    }

    public static void main (String [] args ) {



    }
}
