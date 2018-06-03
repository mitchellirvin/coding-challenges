public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public void inOrder() {
        System.out.print("In Order: ");
        inOrderHelper(this);
        System.out.println();
    }

    private void inOrderHelper(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrderHelper(node.left);
        System.out.print(node.val + " ");
        inOrderHelper(node.right);
    }
}
