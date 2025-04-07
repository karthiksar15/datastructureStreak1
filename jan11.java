public class Jan16 {

    public static void main(String[] args) {

        Jan16 jans = new Jan16();
        TreeNode node1 = jans.new TreeNode(8);
        TreeNode node2 = jans.new TreeNode(3);
        TreeNode node3 = jans.new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = jans.new TreeNode(1);
        TreeNode node5 = jans.new TreeNode(6);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = jans.new TreeNode(4);
        TreeNode node7 = jans.new TreeNode(7);
        node5.left = node6;
        node5.right = node7;
        TreeNode node8 = jans.new TreeNode(14);
        node3.right = node8;
        TreeNode node9 = jans.new TreeNode(13);
        node8.left = node9;
        System.out.println("dif---" + maxAncestorDiff(node1));
    }

    public static int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;

        return helper(root, root.val, root.val);

    }

    public static int helper(TreeNode node, int max, int min) {
        if (node == null) {
            return max - min;
        }
        max = Math.max(node.val, max);
        min = Math.min(node.val, min);
        int left = helper(node.left, max, min);
        int right = helper(node.right, max, min);
        return Math.max(left, right);

    }

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}

