import java.util.*;

public class SortedArrayToBST {
	public static TreeNode sortedArrayToBST(final List<Integer> a) {
	    if (a.size() == 0) {
	        return null;
	    }

	    return helper(a, 0, a.size() - 1);
	}

	public static TreeNode helper(final List<Integer> a, int lo, int hi) {
	    if (lo > hi) {
	        return null;
	    }

	    int mid = (lo + hi) / 2;
		System.out.println("Inserting: " +  a.get(mid));
	    TreeNode node = new TreeNode(a.get(mid));
	    node.left = helper(a, lo, mid - 1);
	    node.right = helper(a, mid + 1, hi);

	    return node;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		sortedArrayToBST(list).inOrder();
	}
}
