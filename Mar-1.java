import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Jan21 {

    public static void main(String[] args) {
        Integer[] arr1 = { 6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5 };
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(7);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(3);
        node4.left = node6;
        node4.right = node7;
        TreeNode node8 = new TreeNode(9);
        node6.left = node8;
        TreeNode node9 = new TreeNode(1);
        TreeNode node10 = new TreeNode(4);
        node7.left = node9;
        node7.right = node10;
        TreeNode node11 = new TreeNode(5);
        node3.left = node11;
        System.out.println("total sum---" + deepestLeavesSum(node1));
    }

    public static Integer deepestLeavesSum(TreeNode node1) {

        // Queue<TreeNode> queue = new LinkedList<>();
        ArrayDeque<TreeNode> currentLevel = new ArrayDeque<>(), nextLevel = new ArrayDeque<>();
        nextLevel.offer(node1);
        int sum = 0;
        while (!nextLevel.isEmpty()) {
            currentLevel = nextLevel.clone();
            nextLevel.clear();
            for (TreeNode node : currentLevel) {
                if (node.left != null) {
                    nextLevel.offer(node.left);
                }
                if (node.right != null) {
                    nextLevel.offer(node.right);
                }
            }
        }
        for (TreeNode node : currentLevel) {
            sum += node.val;
        }

        return sum;

    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
