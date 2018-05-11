import java.util.*;

public class BuildIdenticalTrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; left = null; right = null; }
        public void printNode() {
            System.out.println(val + " ");
        }
    }

    static TreeNode root;

    public static int cntMatrix(TreeNode A, TreeNode B) {
        root = A;

        return inOrderIter(A, B, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static int inOrderIter(TreeNode A, TreeNode B, int max, int min) {
        if (B == null && A != null) {
            return -1;
        }
        if (A == null && B == null) {
            return 0;
        }
        if (B.left == null && A.left != null || B.right == null && A.right != null) {
            return -1;
        }

        System.out.println(A.val + ", " + B.val);

        int nodesInserted = 0;
        if (A.left == null && B.left != null) {
            System.out.println("A(" + A.val + ") has no left child and B(" + B.val + ") does. Max: " + max + ", min: " + min);
            // insert left
            insertNode(root, new TreeNode(A.val));
            if (A.left == null) {
                System.out.println("insert caused structural difference, returning -1");
                return -1;
            }
            nodesInserted++;
        }
        if (A.right == null && B.right != null) {
            System.out.println("A(" + A.val + ") has no right child and B(" + B.val + ") does. Max: " + max + ", min: " + min);
            // insert right
            insertNode(root, new TreeNode(A.val + 1));
            if (A.right == null) {
                System.out.println("insert caused structural difference, returning -1");
                return -1;
            }
            nodesInserted++;
        }

        int left = inOrderIter(A.left, B.left, A.val, min);
        int right = inOrderIter(A.right, B.right, max, A.val);
        if (left == -1 || right == -1) {
            return -1;
        }

        return nodesInserted;
    }

    public static TreeNode insertNode(TreeNode node, TreeNode toInsert) {
        if (node == null) {
            node = toInsert;
            return node;
        }

        if (toInsert.val <= node.val) {
            node.left = insertNode(node.left, toInsert);
        } else {
            node.right = insertNode(node.right, toInsert);
        }

        return node;
    }

    public static void main(String[] args) {
        TreeNode A = new TreeNode(5);
        insertNode(A, new TreeNode(3));
        insertNode(A, new TreeNode(4));
        insertNode(A, new TreeNode(8));
        TreeNode B = new TreeNode(7);
        insertNode(B, new TreeNode(4));
        insertNode(B, new TreeNode(6));
        insertNode(B, new TreeNode(5));
        insertNode(B, new TreeNode(9));
        insertNode(B, new TreeNode(8));
        insertNode(B, new TreeNode(10));
        insertNode(B, new TreeNode(12));
        System.out.println("Inserted: " + cntMatrix(A, B));
    }
}
