// https://www.interviewbit.com/problems/kth-smallest-element-in-tree/

public class KthSmallestElementInBST {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    static int index;
    static int kthSmallest;

    public static int kthsmallest(TreeNode A, int B) {
        kthSmallest = 0;
        index = 0;
        helper(A, B);

        return kthSmallest;
    }

    public static void helper(TreeNode node, int target) {
        if (node == null) {
            return;
        }

        helper(node.left, target);

        index++;
        if (index == target) {
            kthSmallest = node.val;
        }

        helper(node.right, target);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        System.out.println(kthsmallest(root, 3));
    }
}
