
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


public class ZigZagTraversal {

    public static void main(String[] args) {

        ZigZagTraversal zigZagTraversal=new ZigZagTraversal();
        TreeNode node1=zigZagTraversal.new TreeNode(3);
        TreeNode node2=zigZagTraversal.new TreeNode(9);
        TreeNode node3=zigZagTraversal.new TreeNode(20);
        node1.left=node2;
        node1.right=node3;
        TreeNode node4=zigZagTraversal.new TreeNode(15);
        TreeNode node5=zigZagTraversal.new TreeNode(7);
        node3.left=node4;
        node3.right=node5;
     
        System.out.println("deepest leaves-->"+zigZagTraversal.zigzagLevelOrder(node1));
        
    }

     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> resultList=new ArrayList<>();
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        if(root==null) return resultList;
        int order=0;
        while(!queue.isEmpty())
        {
            int len=queue.size();
            List<Integer> levelList=new ArrayList<>();
            for(int i=0;i<len;i++)
            {
                
                TreeNode temp=queue.pollFirst();
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
                levelList.add(temp.val);
            }
            if(order==1)
                Collections.reverse(levelList);
            resultList.add(levelList);    
            order=order==0?1:0;
        }
        return resultList;
         
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

