import java.util.ArrayList;
import java.util.List;

public class Jan11265 {
    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node33 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5);
        node3.left = node1;
        node3.right = node4;
        node1.left = node33;
        node4.left = node11;
        node4.right = node5;
        Jan11265 jan = new Jan11265();
        System.out.println("total--->" + jan.goodNodes(node3));
    }

    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE);
    }

    public int helper(TreeNode root, Integer max) {
        if (root == null)
            return 0;
        int left = helper(root.left, Math.max(root.val, max));
        int right = helper(root.right, Math.max(root.val, max));
        int count = left + right;
        if (root.val >= max)
            count += 1;
        return count;
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
