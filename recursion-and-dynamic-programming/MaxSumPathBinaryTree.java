// https://www.interviewbit.com/problems/max-sum-path-in-binary-tree/

public class MaxSumPathBinaryTree {
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

    static int max;

    public static int maxPathSum(TreeNode A) {
        max = Integer.MIN_VALUE;
        int temp = maxPathSumRec(A);
        return Math.max(max, temp);
    }

    public static int maxPathSumRec(TreeNode current) {
        if (current.left == null && current.right == null) {
            return current.val;
        }

        int left = 0;
        int right = 0;
        if (current.left != null) {
            // if numbers are negative, don't add them to the potential max
            left = Math.max(0, maxPathSumRec(current.left));
        }
        if (current.right != null) {
            // if numbers are negative, don't add them to the potential max
            right = Math.max(0, maxPathSumRec(current.right));
        }

        if (current.val + left + right > max) {
            max = current.val + left + right;
        }

        return current.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println("Expecting max sum to be 18");
        System.out.println("Actual sum: " + maxPathSum(root));
    }
}
