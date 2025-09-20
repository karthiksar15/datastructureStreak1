import java.util.LinkedList;
import java.util.Queue;

public class Jan25 {

    public static void main(String[] args) {

        Jan25 jan = new Jan25();
        TreeNode node1 = jan.new TreeNode(4);
        TreeNode node2 = jan.new TreeNode(2);
        TreeNode node3 = jan.new TreeNode(1);
        TreeNode node4 = jan.new TreeNode(3);
        TreeNode node5 = jan.new TreeNode(5);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        System.out.println("cl-----" + closestValue(node1, 3.71));

    }

    public static int closestValue(TreeNode root, double target) {
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            if (Math.abs(root.val - target) == Math.abs(closest - target)) {
                closest = Math.min(closest, root.val);
            }
            root = target < root.val ? root.left : root.right;
        }
        return closest;
    }

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
