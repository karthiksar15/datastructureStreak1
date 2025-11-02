public class MinDepth {



    public static void main(String[] args) {
        MinDepth minDepth=new MinDepth();
        TreeNode node=minDepth.new TreeNode(3);
        TreeNode node1=minDepth.new TreeNode(9);
        TreeNode node2=minDepth.new TreeNode(20);
        node.left=node1;
        node.right=node2;
        TreeNode node3=minDepth.new TreeNode(15);
        TreeNode node4=minDepth.new TreeNode(7);
        node2.left=node3;
        node2.right=node4;
        // TreeNode node=minDepth.new TreeNode(3);
        // TreeNode node1=minDepth.new TreeNode(9);
        // TreeNode node2=minDepth.new TreeNode(20);
        // TreeNode node3=minDepth.new TreeNode(15);
        // TreeNode node4=minDepth.new TreeNode(7);
        // node.right=node1;
        // node1.right=node2;
        // node2.right=node3;
        // node3.right=node4;
        System.out.println("minimum depth-->"+minDepth.minDepth(node));
    }

     public int minDepth(TreeNode root) {
            
             return dfs(root,Integer.MAX_VALUE,1);
    } 

    public int dfs(TreeNode node,Integer minimum,Integer minimumCnt)
    {
        if(node==null) return 0;
        
        int left=dfs(node.left,minimum,minimumCnt+1);
        int right=dfs(node.right,minimum,minimumCnt+1);

        if(left==0 && right==0)
        {
            return Math.min(minimumCnt,minimum) ;
        }

        if(left!=0 && right!=0)
        {
            return Math.min(left, right);
        }

        return left!=0?left:right;
    }

    class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val)
        {
            this.val=val;
        }
    }

}

