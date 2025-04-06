import java.util.LinkedList;
import java.util.Queue;

public class Jan15 {

    public static void main(String[] args) {
        Jan15 onefive = new Jan15();
        TreeNode three = onefive.new TreeNode(3);
        TreeNode nine = onefive.new TreeNode(9);
        TreeNode twenty = onefive.new TreeNode(20);
        three.left = nine;
        three.right = twenty;
        TreeNode fifteen = onefive.new TreeNode(15);
        TreeNode seven = onefive.new TreeNode(7);
        twenty.left = fifteen;
        twenty.right = seven;
        System.out.println("min depth---" + minDepthAnotherApproach(three));
    }

    public static int minDepth(TreeNode root) {
        return dfs(root);
    }

    public static int minDepthAnotherApproach(TreeNode root) {
        int min = Integer.MAX_VALUE;
        TreeNode prev = null;
        if (root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        int depth = 1;
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null && prev != null) {
                depth += 1;
                q.add(null);
            } else if (node == null && prev == null) {
                break;
            } else if (node.left == null && node.right == null) {
                min = Math.min(min, depth);
            } else if (node.left != null && node.right == null) {
                q.add(node.left);

            } else if (node.right != null && node.left == null) {
                q.add(node.right);

            } else {
                q.add(node.left);
                q.add(node.right);
            }
            prev = node;
        }
        return min;
    }

    private static int dfs(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null)
            return 1 + dfs(root.right);
        else if (root.right == null)
            return 1 + dfs(root.left);
        return 1 + Math.min(dfs(root.left), dfs(root.right));
    }

    class TreeNode {
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

