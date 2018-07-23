// https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/

import java.util.ArrayList;
import java.util.LinkedList;

public class ZigZagLevelOrder {

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> zigzag = new ArrayList<>();
        LinkedList<Integer> zig = new LinkedList<>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(A);

        TreeNode currentNode = null;
        int level = 0;

        while (!queue.isEmpty()) {
            int nodesProcessed = 0;
            int nodesAtCurrentLevel = queue.size();

            while (nodesProcessed < nodesAtCurrentLevel) {
                currentNode = queue.poll();
                addCurrentValToZig(zig, currentNode, level);
                addChildNodesToQueue(queue, currentNode);
                nodesProcessed++;
            }

            zigzag.add(new ArrayList<Integer>(zig));
            zig.clear();
            level++;
        }

        return zigzag;
    }

    public static void addChildNodesToQueue(LinkedList<TreeNode> queue, TreeNode currentNode) {
        if (currentNode.left != null) {
            queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
            queue.add(currentNode.right);
        }
    }

    // if level is odd, we zag (build zig from right to left, instead of left to right)
    public static void addCurrentValToZig(LinkedList<Integer> zig, TreeNode currentNode, int level) {
        if (isOdd(level)) {
            zig.addFirst(currentNode.val);
        } else {
            zig.addLast(currentNode.val);
        }
    }

    public static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(zigzagLevelOrder(root));
    }
    
}
