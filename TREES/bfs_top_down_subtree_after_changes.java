package TREES;

import java.util.*;

public class bfs_top_down_subtree_after_changes {
    /*
     * Approach -
     * At each node we have to find what is the number where we found the last
     * letter same as this position
     * at each node:
     * Check whether we can attach this node to the prev node if found the store it
     * in the edges array
     * dp[i][letter] -> stores where we saw that letter before
     * if the letter was the same at this index then update the answer otherwise
     * copy the same answer as before
     * 
     */
    public static void main(String[] args) {

    }
}