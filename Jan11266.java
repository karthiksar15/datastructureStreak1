import java.util.ArrayList;
import java.util.List;

public class Jan11266 {
    public static void main(String[] args) {

        TreeNode node11 = new TreeNode(1);
        TreeNode node12 = new TreeNode(2);
        TreeNode node111 = new TreeNode(1);
        TreeNode node21 = new TreeNode(1);
        TreeNode node211 = new TreeNode(2);
        TreeNode node22 = new TreeNode(1);
        node11.left = node12;
        node11.right = node111;
        node21.left = node211;
        node21.right = node22;
        Jan11266 jan = new Jan11266();
        System.out.println("total--->" + jan.isSameTree(node11, node21));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        if (left && right && q.val == p.val)
            return true;
        return false;

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
