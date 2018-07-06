/**
Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
*/

import java.util.*;

public class SerializeTree {

    public static String levelOrderSerializeTree(TreeNode node) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        TreeNode next = null;

        while (!queue.isEmpty()) {
            int nodesAtCurrentLevel = queue.size();

            // loop over current level, adding children to next level
            while (nodesAtCurrentLevel > 0) {
                next = queue.poll();

                sb.append(next.val + " ");

                if (next.left != null) {
                    queue.add(next.left);
                } else if (next.val != -1) {
                    queue.add(new TreeNode(-1));
                }

                if (next.right != null) {
                    queue.add(next.right);
                } else if (next.val != -1) {
                    queue.add(new TreeNode(-1));
                }

                nodesAtCurrentLevel--;
            }
        }

        return sb.toString().trim();
    }

    public static String preOrderSerializeTree(TreeNode node) {
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        TreeNode next = null;

        while (!queue.isEmpty()) {
            next = queue.poll();
            sb.append(next.val + " ");

            if (next.left != null) {
                queue.add(next.left);
            }
            if (next.right != null) {
                queue.add(next.right);
            }
        }
    }

    public static TreeNode deserializeTree(String s) {
        String[] values = s.split(" ");
        System.out.println(Arrays.asList(values));
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        String serialized = inOrderSerializeTree(root);
        System.out.println("Serialized: " + serialized);
        deserializeTree(serialized);
    }
}
