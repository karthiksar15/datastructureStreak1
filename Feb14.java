

import java.util.Deque;
import java.util.LinkedList;

public class Closest {

    public static void main(String[] args) {
          Closest closest=new Closest();
        TreeNode node1=closest.new TreeNode(4);
        TreeNode node2=closest.new TreeNode(2);
        TreeNode node3=closest.new TreeNode(5);
        node1.left=node2;
        node1.right=node3;
        TreeNode node4=closest.new TreeNode(1);
        TreeNode node5=closest.new TreeNode(3);
        node2.left=node4;
        node2.right=node5;
        System.out.println("deepest leaves-->"+closest.closestValue(node1,4.5));
        
    }
     public int closestValue(TreeNode root, double target) {
            if(root==null) return 0;
            Deque<TreeNode> queue=new LinkedList<>();
            queue.add(root);
            double min=Integer.MAX_VALUE;
            int closest=root.val;
            while(!queue.isEmpty())
            {
                int count=queue.size();
                for(int i=0;i<count;i++)
                {
                    TreeNode temp=queue.poll();
                    double diff=Math.max(target, temp.val)-Math.min(target, temp.val);
                    if(diff==min && temp.val<closest)
                    {
                        closest=temp.val;
                        min=diff;
                    }else if(diff<min)
                    {
                        closest=temp.val;
                        min=diff;
                    }
                    if(target<temp.val && temp.left!=null)
                    {
                        queue.add(temp.left);
                    } 
                    if(target>temp.val && temp.right!=null)
                    {
                        queue.add(temp.right);
                    }

                }
            }
            return closest;
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
