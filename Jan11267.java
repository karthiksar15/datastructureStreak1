import java.util.ArrayList;
import java.util.List;

public class Jan11267 {
    public static void main(String[] args) {

        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;
        Jan11267 jan = new Jan11267();
        // System.out.println("total--->" + jan.lowestCommonAncestor(node3, node7,
        // node4).val);
        System.out.println("total--->" + jan.lowestCommonAncestor(node3, node5, node1).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (root.val == p.val)
            return root;
        if (root.val == q.val)
            return root;
        if (left != null && right != null)
            return root;
        if (right != null)
            return right;
        return left != null ? left : null;
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
