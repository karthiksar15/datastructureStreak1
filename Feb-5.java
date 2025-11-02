public class LCA {

    public static void main(String[] args) {
        LCA lca=new LCA();
        TreeNode node=lca.new TreeNode(3);
        TreeNode node1=lca.new TreeNode(5);
        TreeNode node2=lca.new TreeNode(1);
        TreeNode node3=lca.new TreeNode(6);
        TreeNode node4=lca.new TreeNode(2);
        TreeNode node5=lca.new TreeNode(0);
        TreeNode node6=lca.new TreeNode(8);
        TreeNode node7=lca.new TreeNode(7);
        TreeNode node8=lca.new TreeNode(4);
        node.left=node1;
        node.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;
        node4.left=node7;
        node4.right=node8;
        System.out.println("LCA--->"+lca.lowestCommonAncestor(node, node7, node5).val);
        
    }
     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
       TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right= lowestCommonAncestor(root.right,p,q);
        if(left!=null & right!=null) return root;
        if(root.val==q.val || root.val==p.val)
            return root;
        return left!=null?left:right;

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

