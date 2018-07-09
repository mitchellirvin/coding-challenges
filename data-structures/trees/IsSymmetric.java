// https://www.interviewbit.com/problems/symmetric-binary-tree/

public class IsSymmetric {
    public static boolean isSymmetric(TreeNode A) {
        return isMirror(A, A);
    }

    public static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a != null && b != null && a.val == b.val) {
            return isMirror(a.left, b.right) && isMirror(a.right, b.left);
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);

        root.inOrder();
        System.out.println("Tree is symmetric: " + isSymmetric(root));

        root.right.right = new TreeNode(3);
        root.inOrder();
        System.out.println("Tree is symmetric: " + isSymmetric(root));
    }
}
