// https://www.interviewbit.com/problems/invert-the-binary-tree/

import java.util.*;

public class InvertBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    public static TreeNode invertTree(TreeNode A) {
        if (A == null) {
            return null;
        }
        invertTreeHelper(A);
        return A;
    }

    public static void invertTreeHelper(TreeNode node) {
        if (node == null) {
            return;
        }
        
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        invertTreeHelper(node.right);
        invertTreeHelper(node.left);
    }

    public static void inorderTraversal(TreeNode node) {
        if(node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.print("Before inversion (inorder): ");
        inorderTraversal(root);
        System.out.println();
        TreeNode reversed = invertTree(root);
        System.out.print("After inversion (inorder): ");
        inorderTraversal(reversed);
        System.out.println();
    }
}
