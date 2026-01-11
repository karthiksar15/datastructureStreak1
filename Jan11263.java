import java.util.ArrayList;
import java.util.List;

public class Jan11263 {

    public static void main(String[] args) {
        Jan11263 jan = new Jan11263();
        TreeNode node0 = jan.new TreeNode(0);
        TreeNode node1 = jan.new TreeNode(1);
        TreeNode node2 = jan.new TreeNode(2);
        TreeNode node3 = jan.new TreeNode(3);
        TreeNode node4 = jan.new TreeNode(4);
        TreeNode node5 = jan.new TreeNode(5);
        TreeNode node6 = jan.new TreeNode(6);
        // TreeNode node8 = jan.new TreeNode(7);
        // TreeNode node9 = jan.new TreeNode(8);
        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        // node4.left = node7;
        // node5.left = node8;
        node2.right = node5;
        node4.right = node6;
        System.out.println(jan.maxDepth(node0));
    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
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
