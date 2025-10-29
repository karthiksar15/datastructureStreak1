public class PathSum {

    int target;

    public static void main(String[] args) {

        TreeNode node1=new TreeNode(5);
        TreeNode node2=new TreeNode(4);
        TreeNode node3=new TreeNode(8);
        node1.left=node2;
        node1.right=node3;
        TreeNode node4=new TreeNode(11);
        node2.left=node4;
        TreeNode node5=new TreeNode(7);
        TreeNode node6=new TreeNode(2);
        node4.left=node5;
        node4.right=node6;
        TreeNode node7=new TreeNode(13);
        TreeNode node8=new TreeNode(4);
        node3.left=node7;
        node3.right=node8;
        TreeNode node9=new TreeNode(1);
        node8.right=node9;   
        PathSum path=new PathSum();
        System.out.println("node path sum--"+path.hasPathSum(node1, 22));
    }
     public boolean hasPathSum(TreeNode root, int targetSum) {
        target = targetSum;
        return dfs(root, 0);
    }
    private boolean dfs(TreeNode node,int curr)
    {
        if(node==null)
            return false;
        if(node.left==null && node.right==null)
        {
            return target==curr+node.val;
        }
        curr+=node.val;
        boolean left=dfs(node.left,curr);
        boolean right=dfs(node.right,curr);
        return left || right;

    }

}
class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val)
        {
            this.val=val;
        }
    }

