// https://www.interviewbit.com/problems/least-common-ancestor/

import java.util.*;

public class LeastCommonAncestor {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; left=null; right=null; }
    }

    public static int lca(TreeNode A, int B, int C) {
        if (!nodeExists(A, B) || !nodeExists(A, C)) {
            return -1;
        }
        TreeNode LCA = getLCA(A, B, C);
        return LCA.val;
    }

    public static TreeNode getLCA(TreeNode node, int A, int B) {
        if (node == null) {
            return null;
        }

        if (node.val == A || node.val == B) {
            return node;
        }

        TreeNode left = getLCA(node.left, A, B);
        TreeNode right = getLCA(node.right, A, B);

        // at node whose left subtree contains one, and right contains the other
        if (left != null && right != null) {
            return node;
        } else if (left != null && right == null) {
            return left;
        } else if (right != null && left == null) {
            return right;
        } else {
            return null;
        }
    }

    public static boolean nodeExists(TreeNode node, int toFind) {
        if (node == null) {
            return false;
        } else if (node.val == toFind) {
            return true;
        }

        boolean exists = false;
        exists |= nodeExists(node.left, toFind);
        exists |= nodeExists(node.right, toFind);

        return exists;
    }

    public static void printTreeInOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        printTreeInOrder(node.left);
        System.out.print(node.val + " ");
        printTreeInOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.right = new TreeNode(5);
        System.out.println("Tree in order: "); 
        printTreeInOrder(root);
        System.out.println();
        System.out.println("LCA of 5 and 6: " + lca(root, 5, 6));
        System.out.println("LCA of 9 and 6: " + lca(root, 9, 6));
    }
}
