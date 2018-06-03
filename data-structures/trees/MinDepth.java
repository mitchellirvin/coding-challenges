//

import java.util.*;

public class MinDepth {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; left = null; right = null; }
    }

    public static int minDepth(TreeNode A) {
        if (A == null) {
            return 0;
        }

        ArrayDeque<TreeNode> currLevel = new ArrayDeque<>();
        currLevel.add(A);
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<>();

        int depth = 1;

        while (!currLevel.isEmpty()) {
            TreeNode next = currLevel.poll();

            if (next.left == null && next.right == null) {
                return depth;
            }

            if (next.left != null) {
                nextLevel.add(next.left);
            }
            if (next.right != null) {
                nextLevel.add(next.right);
            }

            if (currLevel.isEmpty()) {
                currLevel = nextLevel.clone();
                nextLevel.clear();
                depth++;
            }
        }

        return 0;
    }

    public static void inorderTraversal(TreeNode node) {
        if(node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        System.out.print("Tree: ");
        inorderTraversal(root);
        System.out.println("\nMin Depth: " + minDepth(root));

    }
}
