import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Nov2226 {

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
        Nov2226 nov = new Nov2226();
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
        Map<TreeNode, int[]> mp = new HashMap<>();
        mp.put(null, new int[] { 0, 0 });
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if (node.left != null && !mp.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !mp.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                node = stack.pop();

                int[] leftData = mp.get(node.left);
                int[] rightData = mp.get(node.right);

                int leftHeight = leftData[0], leftDiameter = leftData[1];
                int rightHeight = rightData[0], rightDiameter = rightData[1];

                int height = 1 + Math.max(leftHeight, rightHeight);
                int diameter = Math.max(leftHeight + rightHeight,
                        Math.max(leftDiameter, rightDiameter));

                mp.put(node, new int[] { height, diameter });
            }
        }
        return mp.get(root)[1];
    }

}
