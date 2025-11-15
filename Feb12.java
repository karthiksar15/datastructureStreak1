public class MinimumAbsoluteDiff {

    public static void main(String[] args) {
        // Build a sample BST: [4,2,6,1,3]
        MinimumAbsoluteDiff absDiff = new MinimumAbsoluteDiff();
        TreeNode node1 = absDiff.new TreeNode(4);
        TreeNode node2 = absDiff.new TreeNode(2);
        TreeNode node3 = absDiff.new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = absDiff.new TreeNode(1);
        TreeNode node5 = absDiff.new TreeNode(3);
        node2.left = node4;
        node2.right = node5;

        System.out.println("getMinimumDifference--->" + absDiff.getMinimumDifference(node1)); // expected 1
    }

    // Computes the minimum absolute difference between values of any two nodes in a BST.
    // Correct approach: in-order traversal yields sorted values; track difference with previous value.
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        // state[0] = minDiff, state[1] = prevVal, state[2] = hasPrev (0/1)
        int[] state = new int[]{Integer.MAX_VALUE, 0, 0};
        inorder(root, state);
        return state[0];
    }

    private void inorder(TreeNode node, int[] state) {
        if (node == null) return;
        inorder(node.left, state);

        if (state[2] == 1) { // has previous value
            int diff = Math.abs(node.val - state[1]);
            if (diff < state[0]) state[0] = diff;
        }
        state[1] = node.val;
        state[2] = 1;

        inorder(node.right, state);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}
