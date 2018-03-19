// https://www.interviewbit.com/problems/balanced-binary-tree/

import java.util.*;

public class IsHeightBalanced {
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

    public static int isBalanced(TreeNode A) {
        if(A == null) return 1;

        TreeNode next = A;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(next);

        while(!queue.isEmpty()) {
            next = queue.poll();

            if(Math.abs(getBranchHeight(next.right) - getBranchHeight(next.left)) > 1) return 0;
            if(next.left != null) queue.add(next.left);
            if(next.right != null) queue.add(next.right);
        }

        return 1;
    }


    public static int getBranchHeight(TreeNode node) {
        if(node == null) return 0;

        if(node.left != null && node.right != null) return Math.max(1 + getBranchHeight(node.left), 1 + getBranchHeight(node.right));
        else if(node.left != null) return 1 + getBranchHeight(node.left);
        else return 1 + getBranchHeight(node.right);
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

        System.out.print("Balanced: ");
        inorderTraversal(root);
        System.out.println();
        if(isBalanced(root) == 1) System.out.println("Tree is balanced");

        root.right.right.right = new TreeNode(8);
        root.right.right.right.right = new TreeNode(9);
        System.out.print("Imbalanced: ");
        inorderTraversal(root);
        System.out.println();
        if(isBalanced(root) == 0) System.out.println("Tree is imbalanced");
    }
}
