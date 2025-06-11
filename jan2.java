public class Trial6 {

    public static int found;

    public static void main(String[] args) {
        Trial6 t6 = new Trial6();
        TreeNode node1 = t6.new TreeNode(3);
        TreeNode node2 = t6.new TreeNode(5);
        TreeNode node3 = t6.new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = t6.new TreeNode(6);
        TreeNode node5 = t6.new TreeNode(2);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = t6.new TreeNode(7);
        TreeNode node7 = t6.new TreeNode(4);
        node5.left = node6;
        node5.right = node7;
        TreeNode node8 = t6.new TreeNode(0);
        TreeNode node9 = t6.new TreeNode(8);
        node3.left = node8;
        node3.right = node9;
        System.out.println("lca found---" + findLca(node1, 6, 2));

    }

    public static int findLca(TreeNode t1, int n1, int n2) {
        if (t1 == null) {
            return 0;
        }
        if (t1.val == n1 || t1.val == n2)
            return t1.val;
        int left = findLca(t1.left, n1, n2);
        int right = findLca(t1.right, n1, n2);

        if (left != 0 && right != 0) {
            return t1.val;
        }

        if (left != 0)
            return left;
        // found = found != 0 ? found : ();
        // return found;
        return right;
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

