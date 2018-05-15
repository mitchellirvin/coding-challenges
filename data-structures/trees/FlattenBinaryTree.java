// https://www.interviewbit.com/problems/flatten-binary-tree-to-linked-list/

public class FlattenBinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; left = null; right = null; }
    }

    public static TreeNode flatten(TreeNode a) {
        helper(a);
        return a;
    }

    public static void helper(TreeNode node) {
        if (node == null) {
            return;
        }

        helper(node.left);
        helper(node.right);

        if (node.left != null) {
            TreeNode temp = node.right;
            node.right = node.left;
            node.left = null;
            while (node.right != null) {
                node = node.right;
            }
            node.right = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        flatten(root);
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.right;
        }
        System.out.println();
    }
}
