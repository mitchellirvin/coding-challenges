//

import java.util.*;

public class LevelOrder {
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

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<>();
        ArrayList<Integer> level = new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        TreeNode curr = null;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            while (levelSize > 0) {
                curr = queue.poll();
                level.add(curr.val);

                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                levelSize--;
            }

            levels.add(new ArrayList<Integer>(level));
            level.clear();
        }

        return levels;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> levels = levelOrder(root);
        for (ArrayList<Integer> level : levels) {
            for (int n : level) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
