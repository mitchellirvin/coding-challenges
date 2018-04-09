//

import java.util.*;

public class GenerateUniqueBSTs {
    static class TreeNode {
        private int val;
        private TreeNode right;
        private TreeNode left;
        public TreeNode(int val) { this.val = val; }
    }

    public static ArrayList<TreeNode> generateTrees(int a) {
        return generateTrees(1, a);
    }

    public static ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> trees = new ArrayList<>();

        if (start > end) {
            trees.add(null);
        } else {
            for (int i = start; i <= end; i++) {
                ArrayList<TreeNode> lefts = generateTrees(start, i - 1);
                ArrayList<TreeNode> rights = generateTrees(i + 1, end);
                for (TreeNode right : rights) {
                    for (TreeNode left : lefts) {
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        trees.add(root);
                    }
                }
            }
       }

       return trees;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + ", ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        System.out.println("Preorder, all possible BSTs of 1, 2, 3, and 4.");
        ArrayList<TreeNode> trees = generateTrees(4);
        for (TreeNode root : trees) {
            printTree(root);
            System.out.println();
        }
    }
}
