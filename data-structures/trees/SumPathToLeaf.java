// https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/

import java.util.*;

public class SumPathToLeaf {
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

    public static ArrayList<Integer> branchSums;

    public static int sumNumbers(TreeNode A) {
        branchSums = new ArrayList<Integer>();
        branchSums.clear();

        TreeNode next = A;
        findBranchSums(next, 0);

        int sum = 0;
        for(int n : branchSums) {
            // System.out.print(n + " ");
            sum += n;
            sum %= 1003;
        }
        // System.out.println();

        return sum;
    }

    public static void findBranchSums(TreeNode node, int sum) {
        // base case
        if(node == null) return;

        // add current node's value, prevent overflow with modulus
        sum = ((sum * 10) + node.val) % 1003;

        // reached a leaf
        if(node.left == null && node.right == null) {
            branchSums.add(sum);
            return;
        }

        findBranchSums(node.left, sum);
        findBranchSums(node.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int n = sumNumbers(root);
        System.out.println("Should sum to 522: " + n);
    }
}
