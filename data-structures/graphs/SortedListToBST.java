//

import java.util.*;

public class SortedListToBST {
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

	static class ListNode {
		public int val;
		public ListNode next;
		ListNode(int x) { val = x; next = null; }
	}

	public static TreeNode sortedListToBST(ListNode listItem) {
	    if (listItem == null) {
	        return null;
	    }
        ArrayList<Integer> items = listToArray(listItem);

	    return listToBSTHelper(items, 0, items.size() - 1);
	}

	public static TreeNode listToBSTHelper(ArrayList<Integer> items, int left, int right) {
	    if (left > right) {
	        return null;
	    }
	    int mid = (left + right) / 2;

	    TreeNode parent = new TreeNode(items.get(mid));
	    parent.left = listToBSTHelper(items, left, mid - 1);
	    parent.right = listToBSTHelper(items, mid + 1, right);

	    return parent;
	}

	public static ArrayList<Integer> listToArray(ListNode node) {
	    ArrayList<Integer> array = new ArrayList<>();
	    while (node != null) {
	        array.add(node.val);
	        node = node.next;
	    }
	    return array;
	}

	public static void printTree(TreeNode node) {
	    if (node == null) {
	        return;
	    }
	    printTree(node.left);
	    System.out.print(" " + node.val);
	    printTree(node.right);
	}

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
		ListNode ref = head;
		for (int i = 2; i <= 5; i++) {
			ref.next = new ListNode(i);
			ref = ref.next;
		}

		System.out.println("Linked list: 1 -> 2 -> 3 -> 4 -> 5 ->");
		System.out.print("BST (in order): ");
		TreeNode root = sortedListToBST(head);
		printTree(root);
		System.out.println();
    }
}
