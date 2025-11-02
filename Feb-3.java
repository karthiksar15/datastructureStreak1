
public class GoodNode {

    public static void main(String[] args) {
        GoodNode good=new GoodNode();
        TreeNode node=good.new TreeNode(5);
        TreeNode node1=good.new TreeNode(4);
        TreeNode node2=good.new TreeNode(8);
        node.left=node1;
        node.right=node2;
        TreeNode node3=good.new TreeNode(11);
        node1.left=node3;
        TreeNode node4=good.new TreeNode(13);
        TreeNode node5=good.new TreeNode(4);
        node2.left=node4;
        node2.right=node5;
        TreeNode node6=good.new TreeNode(7);
        TreeNode node7=good.new TreeNode(2);
        node3.left=node6;
        node3.right=node7;
        TreeNode node8=good.new TreeNode(1);
        node5.right=node8;
        System.out.println("good nodes--->"+good.goodNodes(node));

        
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    public int dfs(TreeNode node,Integer max)
    {
        if(node==null) return 0;
    
        int left=dfs(node.left,Math.max(max, node.val));
        int right=dfs(node.left,Math.max(max, node.val));
        int sum=left+right;
        if(node.val>max)return sum+1;
        return sum;
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

