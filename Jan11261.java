import java.util.ArrayList;
import java.util.List;

public class Jan11261 {

    public static void main(String[] args) {
        Jan11261 jan = new Jan11261();
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
        System.out.println(jan.inOrder(node0));
    }

    public List<Integer> inOrder(TreeNode node) {
        List<Integer> resuList = new ArrayList<>();
        helper(node, resuList);
        return resuList;
    }

    public void helper(TreeNode root, List<Integer> inOrderList) {
        if (root == null)
            return;

        helper(root.left, inOrderList);
        inOrderList.add(root.val);
        helper(root.right, inOrderList);

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
