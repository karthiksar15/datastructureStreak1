import javax.swing.tree.TreeNode;

public class Jan17 {

    public static void main(String[] args) {

        Jan17 jan = new Jan17();

        TreeNode node1 = jan.new TreeNode(1);
        TreeNode node2 = jan.new TreeNode(2);
        TreeNode node3 = jan.new TreeNode(3);
        TreeNode node4 = jan.new TreeNode(4);
        TreeNode node5 = jan.new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println("diameter---" + diameterOfBinaryTree(node1));

    }

    public static int diameterOfBinaryTree(TreeNode root) {

        int[] diameter = new int[1];
        longestPath(root, diameter);
        return diameter[0];

    }

    public static int longestPath(TreeNode root, int[] diameter) {
        if (root == null)
            return 0;
        int leftPath = longestPath(root.left, diameter);
        int rightPath = longestPath(root.right, diameter);
        diameter[0] = Math.max(diameter[0], leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

    }

}
