/*
From GeeksForGeeks:
1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.
 */

import java.util.*;

public class InOrderIterative {
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

    public static ArrayList<Integer> inorderTraversal(TreeNode A) {
        if(A == null) return new ArrayList<Integer>();
        ArrayList<Integer> inorderList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode next = A;

        while(next != null) {
            stack.push(next);
            next = next.left;
        }

        while(!stack.isEmpty()) {
            next = stack.pop();
            inorderList.add(next.val);

            if(next.right != null) {
                next = next.right;

                while(next != null) {
                    stack.push(next);
                    next = next.left;
                }
            }
        }

        return inorderList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<Integer> result = inorderTraversal(root);
        System.out.println();
        for(int n : result) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
