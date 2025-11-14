
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LargestInRow {

    public static void main(String[] args) {
        LargestInRow large=new LargestInRow();
        TreeNode node1=large.new TreeNode(1);
        TreeNode node2=large.new TreeNode(3);
        TreeNode node3=large.new TreeNode(2);
        node1.left=node2;
        node1.right=node3;
        TreeNode node4=large.new TreeNode(5);
        TreeNode node5=large.new TreeNode(3);
        node2.left=node4;
        node2.right=node5;
        TreeNode node6=large.new TreeNode(9);
        node3.right=node6;
        System.out.println("Largest --->"+large.largestValues(node1));
        
    }

       public List<Integer> largestValues(TreeNode root) {
            Deque<TreeNode> queue=new LinkedList<>();
            List<Integer> maxIntegers=new ArrayList<>();
            queue.add(root);
            while(!queue.isEmpty())
            {
                int len=queue.size();
                int max=Integer.MIN_VALUE;
                for(int i=0;i<len;i++)
                {
                    TreeNode temp=queue.poll();
                    max=Math.max(temp.val, max);
                    if(temp.left!=null)queue.add(temp.left);
                    if(temp.right!=null)queue.add(temp.right);
                }
                maxIntegers.add(max);
            }
            return maxIntegers;
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

