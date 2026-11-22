public class Nov2126 {

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
        Nov2126 nov = new Nov2126();
        TreeNode node1 = nov.new TreeNode(1);
        TreeNode node2 = nov.new TreeNode(2);
        node1.right = node2;
        TreeNode node3 = nov.new TreeNode(3);
        TreeNode node4 = nov.new TreeNode(4);
        node2.left = node3;
        node2.right = node4;
        TreeNode node5 = nov.new TreeNode(5);
        node3.left = node5;
        System.out.println("diameter--->" + nov.diameterOfBinaryTree(node1));
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int[] nums = { 0, 0 };
        dfs(root, nums);
        return nums[0];
    }

    public int dfs(TreeNode root, int[] cnt) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left, cnt);
        int right = dfs(root.right, cnt);
        cnt[0] = Math.max(cnt[0], left + right);
        return 1 + Math.max(left, right);
        // cnt[0] += 1;
        // cnt[1] = Math.max(cnt[1], cnt[0]);
    }

}
