public class DiameterOfTree {

    public static void main(String[] args) {

        DiameterOfTree dot=new DiameterOfTree();
        TreeNode node1=dot.new TreeNode(1);
        TreeNode node2=dot.new TreeNode(2);
        TreeNode node3=dot.new TreeNode(3);
        TreeNode node4=dot.new TreeNode(4);
        TreeNode node5=dot.new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        node2.right=node5;
        System.out.println("diamter---"+dot.diameterOfBinaryTree(node1));
    }
     public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return -1;
        int[] max=new int[]{0};
         dfs(root,max);
         return max[0];
        
    }

    public static int dfs(TreeNode node,int[] diamter)
    {
        if(node==null) return -1;
        int left=dfs(node.left,diamter);
        int right=dfs(node.right,diamter);
        int path=left+right+2;
        if(path>diamter[0]) diamter[0]=path;
        return Math.max(left, right)+1;
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

