import java.util.Deque;
import java.util.LinkedList;

public class InsertIntoBst {

    public static void main(String[] args) {
        InsertIntoBst iib=new InsertIntoBst();
        TreeNode node=iib.new TreeNode(4);
        TreeNode node1=iib.new TreeNode(2);
        TreeNode node2=iib.new TreeNode(7);
        TreeNode node3=iib.new TreeNode(1);
        TreeNode node4=iib.new TreeNode(3);
        node.left=node1;
        node.right=node2;
        node1.left=node3;
        node1.right=node4;
        iib.printTree(iib.insertIntoBST(node, 5));
        // System.out.println("LCA--->"+ );
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int len=queue.size();
            
            for(int i=0;i<len;i++)
            {
                TreeNode temp=queue.poll();    
                if(temp.left!=null && val<temp.val)
                    queue.add(temp.left);
                if(temp.right!=null && val>temp.val)
                    queue.add(temp.right);
                if(temp.left==null && val<temp.val)
                {
                    temp.left=new TreeNode(val);
                    queue.clear();
                    break;
                }
                if(temp.right==null && val>temp.val)
                {
                    temp.right=new TreeNode(val);
                    queue.clear();
                    break;
                }
            }
                
            
        }
        return root;
    }
    public void printTree(TreeNode node)
    {
        if(node==null) System.out.println("nulll");
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty())
        {
            int len=queue.size();
            for(int i=0;i<len;i++)
            {    
                TreeNode temp=queue.poll();
                System.out.println("node val-->"+temp.val);   
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
            }
              
        }
    }
    // public void constructTree(TreeNode root,TreeNode node)
    // {
    //        Deque<TreeNode> queue=new LinkedList<>();
    //             queue.add(node);
    //             while(!queue.isEmpty())
    //             {
    //                 int len=queue.size();
    //                 TreeNode temp=queue.poll();
    //                 for(int i=0;i<len;i++)
    //                 {
    //                     if()
    //                 }
    //             }
    // }

    class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
         public TreeNode()
        {
        }
        public TreeNode(int val)
        {
            this.val=val;
        }

    }

}
