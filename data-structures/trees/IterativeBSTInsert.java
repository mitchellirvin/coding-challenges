// https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem

import java.util.*;

public class IterativeBSTInsert {
    public static TreeNode insert(TreeNode root,int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode parent = null;
        TreeNode curr = root;

        while (curr != null) {
            parent = curr;

            if (curr.val > val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (parent.val < val) {
            parent.right = new TreeNode(val);
        } else {
            parent.left = new TreeNode(val);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = null;
        List<Integer> nodes = Arrays.asList(4, 2, 3, 1, 7, 6);

        for (int n : nodes) {
            root = insert(root, n);
        }

        root.inOrder();
        root.preOrder();
    }
}
