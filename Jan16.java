import java.util.LinkedList;
import java.util.Queue;

public class Jan24 {

    public static void main(String[] args) {
        Jan24 jan = new Jan24();
        TreeNode node1 = jan.new TreeNode(4);
        TreeNode node2 = jan.new TreeNode(2);
        TreeNode node3 = jan.new TreeNode(1);
        TreeNode node4 = jan.new TreeNode(3);
        TreeNode node5 = jan.new TreeNode(7);
        node1.left = node2;
        node1.right = node5;
        node2.left = node3;
        node2.right = node4;
        insertIntoBST(node1, 5);
        printTree(node1);
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        Jan24 jan = new Jan24();
        TreeNode newNode = jan.new TreeNode(val);
        return insertNewNode(root, newNode, true);
    }

    public static TreeNode insertNewNode(TreeNode node, TreeNode newNode, boolean rootCheck) {
        if (node == null)
            return newNode;
        if (node.val == newNode.val) {
            return node;
        }

        if (newNode.val < node.val) {
            if (insertNewNode(node.left, newNode, rootCheck).equals(newNode)) {
                node.left = newNode;
            }
        } else if (newNode.val > node.val) {
            if (insertNewNode(node.right, newNode, rootCheck).equals(newNode)) {
                node.right = newNode;
            }
        }
        return node;
    }

    public static void printTree(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.println(temp.val);
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
    }

    class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}

