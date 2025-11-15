
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class DeepestLeaves {

    public static void main(String[] args) {

        DeepestLeaves deepestLeaves=new DeepestLeaves();
        TreeNode node1=deepestLeaves.new TreeNode(6);
        TreeNode node2=deepestLeaves.new TreeNode(7);
        TreeNode node3=deepestLeaves.new TreeNode(8);
        node1.left=node2;
        node1.right=node3;
        TreeNode node4=deepestLeaves.new TreeNode(2);
        TreeNode node5=deepestLeaves.new TreeNode(7);
        node2.left=node4;
        node2.right=node5;
        TreeNode node6=deepestLeaves.new TreeNode(1);
        TreeNode node7=deepestLeaves.new TreeNode(3);
        node3.left=node6;
        node3.right=node7;
        TreeNode node8=deepestLeaves.new TreeNode(9);
        node4.left=node8;
        TreeNode node9=deepestLeaves.new TreeNode(1);
        TreeNode node10=deepestLeaves.new TreeNode(4);
        node5.left=node9;
        node5.right=node10;
        TreeNode node11=deepestLeaves.new TreeNode(5);
        node7.right=node11;
        System.out.println("deepest leaves-->"+deepestLeaves.deepestLeavesSum(node1));
        
    }

    public int deepestLeavesSum(TreeNode root) {
        Deque<TreeNode> queue=new LinkedList<>();
        List<Integer> numsList=null;
        queue.add(root);
        while(!queue.isEmpty())
        {
            numsList=new ArrayList<>();
            int count=queue.size();
            for(int i=0;i<count;i++)
            {
                TreeNode temp=queue.poll();
                numsList.add(temp.val); 
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);

            }
        }
        return numsList!=null?numsList.stream().collect(Collectors.summingInt(Integer::intValue)):0;
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
