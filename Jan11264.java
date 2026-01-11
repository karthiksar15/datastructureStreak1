import java.util.ArrayList;
import java.util.List;

public class Jan11264 {

    public int target;

    public static void main(String[] args) {

        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        // TreeNode node8 = jan.new TreeNode(7);
        // TreeNode node9 = jan.new TreeNode(8);
        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        // node4.left = node7;
        // node5.left = node8;
        node8.left = node13;
        node8.right = node4;
        node4.right = node1;
        Jan11264 jan = new Jan11264();
        System.out.println(jan.hasPathSum(node5, 22));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.target = targetSum;
        return helper(root, 0);
    }

    public boolean helper(TreeNode root, int count) {
        if (root == null)
            return false;
        count += root.val;
        if (root.left == null && root.right == null) {
            return count == this.target;
        }
        boolean left = helper(root.left, count);
        boolean right = helper(root.right, count);
        return left || right;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
