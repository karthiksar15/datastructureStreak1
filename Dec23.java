import java.util.LinkedList;
import java.util.Queue;

public class Jan19 {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(7);
        node4.left = node5;
        TreeNode node6 = new TreeNode(2);
        node4.right = node6;
        TreeNode node7 = new TreeNode(13);
        node3.left = node7;
        TreeNode node8 = new TreeNode(4);
        node3.right = node8;
        TreeNode node9 = new TreeNode(1);
        node8.right = node9;

        printInBFS(node1);

    }

    public static void printInBFS(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                TreeNode node1 = queue.remove();
                System.out.println(node1.val);
                if (node1.left != null) {
                    queue.add(node1.left);
                }
                if (node1.right != null) {
                    queue.add(node1.right);
                }
            }
        }
    }

    static class TreeNode {
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

