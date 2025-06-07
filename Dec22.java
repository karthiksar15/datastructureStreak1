import java.util.Stack;

public class Trial2 {

    public static void main(String[] args) {

        Trial2 t2 = new Trial2();

        TreeNode node1 = t2.new TreeNode(0);
        TreeNode node2 = t2.new TreeNode(1);
        TreeNode node3 = t2.new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = t2.new TreeNode(3);
        TreeNode node5 = t2.new TreeNode(4);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = t2.new TreeNode(5);
        TreeNode node7 = t2.new TreeNode(6);
        node3.right = node6;
        node6.right = node7;
        System.out.println("Maxxx depth---" + maxDepth(node1));
        System.out.println("Maxxx depth iterative---" + maxDepthIterative(node1));

    }

    public static int maxDepth(TreeNode node1) {
        if (node1 == null)
            return 0;
        int left = maxDepth(node1.left);
        int right = maxDepth(node1.right);
        return Math.max(left, right) + 1;

    }

    public static int maxDepthIterative(TreeNode node1) {
        Stack<MaxDepth> stack = new Stack<>();
        Trial2 t2 = new Trial2();
        stack.push(t2.new MaxDepth(1, node1));
        int ans = 0;
        while (!stack.isEmpty()) {
            MaxDepth temp = stack.pop();
            ans = Math.max(ans, temp.depth);
            if (temp.treeNode.left != null)
                stack.push(t2.new MaxDepth(temp.depth + 1, temp.treeNode.left));
            if (temp.treeNode.right != null)
                stack.push(t2.new MaxDepth(temp.depth + 1, temp.treeNode.right));
        }
        return ans;
    }

    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    class MaxDepth {
        public TreeNode treeNode;
        public int depth;

        public MaxDepth(int depth, TreeNode treeNode) {
            this.depth = depth;
            this.treeNode = treeNode;
        }
    }

}

