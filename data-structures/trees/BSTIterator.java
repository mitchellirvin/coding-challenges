// https://www.interviewbit.com/problems/bst-iterator/

import java.util.*;

public class BSTIterator {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; left = null; right = null; }
    }

    private static ArrayDeque<TreeNode> pathStack;

    public BSTIterator(TreeNode root) {
        pathStack = new ArrayDeque<>();
        pushLefts(root);
    }

    public static void pushLefts(TreeNode node) {
        while (node != null) {
            pathStack.push(node);
            node = node.left;
        }
    }

    public boolean hasNext() {
        return !pathStack.isEmpty();
    }

    public int next() {
        if (pathStack.isEmpty()) {
            throw new IllegalStateException();
        }
        TreeNode next = pathStack.pop();
        pushLefts(next.right);
        return next.val;
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);

        System.out.println("Tree In Order: ");
        printTreeInOrder(root);
        System.out.println();
        System.out.println("Using Iterator: ");

        BSTIterator iter = new BSTIterator(root);
        while (iter.hasNext()) {
            System.out.print(iter.next() + " ");
        }
        System.out.println(); 
    }
}
