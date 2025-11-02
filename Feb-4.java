
public class SameTree {

    public static void main(String[] args) {
        SameTree same=new SameTree();
        
        TreeNode nodeTree1=same.new TreeNode(5);
        TreeNode node1=same.new TreeNode(4);
        TreeNode node2=same.new TreeNode(8);
        nodeTree1.left=node1;
        nodeTree1.right=node2;
        TreeNode node3=same.new TreeNode(11);
        node1.left=node3;
        TreeNode node4=same.new TreeNode(13);
        TreeNode node5=same.new TreeNode(4);
        node2.left=node4;
        node2.right=node5;
        TreeNode node6=same.new TreeNode(7);
        TreeNode node7=same.new TreeNode(2);
        node3.left=node6;
        node3.right=node7;
        TreeNode node8=same.new TreeNode(1);
        node5.right=node8;

        TreeNode nodeTree2=same.new TreeNode(5);
        TreeNode node21=same.new TreeNode(4);
        TreeNode node22=same.new TreeNode(8);
        nodeTree2.left=node21;
        nodeTree2.right=node22;
        TreeNode node23=same.new TreeNode(11);
        node21.left=node23;
        TreeNode node24=same.new TreeNode(13);
        TreeNode node25=same.new TreeNode(4);
        node22.left=node24;
        node22.right=node25;
        TreeNode node26=same.new TreeNode(7);
        TreeNode node27=same.new TreeNode(2);
        node23.left=node26;
        node23.right=node27;
        // TreeNode node28=same.new TreeNode(null);
        // node25.right=node28;

        System.out.println("Same tree check--"+same.sameTree(nodeTree1, nodeTree2));
        
    }

    public boolean sameTree(TreeNode node1,TreeNode node2)
    {
        if(node1==null && node2==null) return true;
        if(node1 ==null || node2 ==null) return false;
        if(node1.val!=node2.val) return false;
        boolean left=sameTree(node1.left, node2.left);
        boolean right=sameTree(node1.right, node2.right);
        return  left && right;
    }

    

    class TreeNode
    {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val)
        {
            this.val=val;
        }
    }

}
