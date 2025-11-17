/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
         if(root==null) return new TreeNode(val);
        Deque<TreeNode> queue=new LinkedList<>();
        TreeNode newRoot=new TreeNode(root.val);
        queue.add(root);
        while(!queue.isEmpty())
        {
            int len=queue.size();
            TreeNode temp=queue.poll();
            for(int i=0;i<len;i++)
            {    
                if(temp.left!=null && val<temp.val)
                    queue.add(temp.left);
                if(temp.right!=null && val>temp.val)
                    queue.add(temp.right);
            }
                if(temp.left==null && val<temp.val)
                {
                    temp.left=new TreeNode(val);
                    break;
                }
                if(temp.right==null && val>temp.val)
                {
                    temp.right=new TreeNode(val);
                    break;
                }
            
        }
        return root;
    }
}
