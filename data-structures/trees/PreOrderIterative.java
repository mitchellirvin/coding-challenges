import java.util.*;

/*
Description from GeeksForGeeks:
1) Create an empty stack nodeStack and push root node to stack.
2) Do following while nodeStack is not empty.
….a) Pop an item from stack and print it.
….b) Push right child of popped item to stack
….c) Push left child of popped item to stack
*/
// https://www.interviewbit.com/problems/preorder-traversal/

public class PreOrderIterative {
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

    public static ArrayList<Integer> preorderTraversal(TreeNode A) {
        if(A == null) return new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> preorderList = new ArrayList<>();

        TreeNode nextNode = A;
        stack.push(nextNode);

        while(!stack.isEmpty()) {
            TreeNode next = stack.pop();
            preorderList.add(next.val);
            if(next.right != null) stack.push(next.right);
            if(next.left != null) stack.push(next.left);
        }

        return preorderList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<Integer> result = preorderTraversal(root);
        System.out.println();
        for(int n : result) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
