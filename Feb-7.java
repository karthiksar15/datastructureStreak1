

public class MaxDiffNode {

    public static void main(String[] args) {
        MaxDiffNode mxDiff=new MaxDiffNode();
        TreeNode treeNode=mxDiff.new TreeNode(8);
        TreeNode treeNode2=mxDiff.new TreeNode(3);
        TreeNode treeNode3=mxDiff.new TreeNode(10);
        treeNode.left=treeNode2;
        treeNode.right=treeNode3;
        TreeNode treeNode4=mxDiff.new TreeNode(1);
        treeNode2.left=treeNode4;
        TreeNode treeNode5=mxDiff.new TreeNode(6);
        treeNode2.right=treeNode5;
        TreeNode treeNode6=mxDiff.new TreeNode(14);
        treeNode3.right=treeNode6;
        TreeNode treeNode7=mxDiff.new TreeNode(4);
        TreeNode treeNode8=mxDiff.new TreeNode(7);
        treeNode5.left=treeNode7;
        treeNode5.right=treeNode8;
        TreeNode treeNode9=mxDiff.new TreeNode(13);
        treeNode6.left=treeNode9;
        System.out.println("---->"+mxDiff.maxAncestorDiff(treeNode));
    }
    public int maxAncestorDiff(TreeNode root) {
            if(root==null) return 0;
            return dfs(root,root.val,root.val);
    }

    public int dfs(TreeNode node,int currMax,int currMin)
    {
        if(node==null) return currMax-currMin;
        currMax=Math.max(currMax, node.val);
        currMin=Math.min(currMin, node.val);
        int left=dfs(node.left, currMax, currMin);
        int right=dfs(node.right, currMax, currMin);
        return Math.max(left, right);
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

}
