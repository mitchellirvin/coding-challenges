import java.util.*;

/*
Description from GeeksForGeeks:
1. Push root to first stack.
2. Loop while first stack is not empty
   2.1 Pop a node from first stack and push it to second stack
   2.2 Push left and right children of the popped node to first stack
3. Print contents of second stack
*/
// https://www.interviewbit.com/problems/postorder-traversal/

public class PostOrderIterative {
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

    public static ArrayList<Integer> postorderTraversal(TreeNode A) {
        if(A == null) return new ArrayList<Integer>();

        Stack<TreeNode> stackOne = new Stack<>();
        Stack<TreeNode> stackTwo = new Stack<>();
        ArrayList<Integer> postorderList = new ArrayList<>();

        TreeNode nextNode = A;
        stackOne.push(nextNode);

        while(!stackOne.isEmpty()) {
            nextNode = stackOne.pop();
            System.out.println("pushing: " + nextNode.val + " onto stackTwo");
            stackTwo.push(nextNode);
            if(nextNode.left != null) {
                System.out.println("pushing: " + nextNode.left.val + " onto stackOne");
                stackOne.push(nextNode.left);
            }
            if(nextNode.right != null) {
                System.out.println("pushing: " + nextNode.right.val + " onto stackOne");
                stackOne.push(nextNode.right);
            }
        }

        while(!stackTwo.isEmpty()) {
            postorderList.add(stackTwo.pop().val);
        }

        return postorderList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<Integer> result = postorderTraversal(root);
        System.out.println();
        for(int n : result) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
