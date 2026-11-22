public class Nov22262 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Nov22262 nov = new Nov22262();
        TreeNode node1 = nov.new TreeNode(1);
        TreeNode node2 = nov.new TreeNode(2);
        node1.right = node2;
        TreeNode node3 = nov.new TreeNode(3);
        node1.left = node3;
        TreeNode node4 = nov.new TreeNode(4);
        node3.left = node4;
        System.out.println("diameter--->" + nov.isBalanced(node1));

    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    int[] dfs(TreeNode root) {
        if (root == null)
            return new int[] { 1, 0 };
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        boolean balanced = (left[0] == 1 && right[0] == 1 && Math.abs(left[1] - right[1]) <= 1);
        int height = 1 + Math.max(left[1], right[1]);
        return new int[] { balanced ? 1 : 0, height };

    }

}
