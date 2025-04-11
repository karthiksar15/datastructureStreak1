
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
    public int maxAncestorDiff(TreeNode root) {
        
        if(root==null)
            return 0;
        int depth=helper(root,root.val,root.val);
        return depth;
        
    }
    
    public int helper(TreeNode node,int max,int min)
    {
            if(node==null)
                return max-min;
            max=Math.max(node.val,max);
            min=Math.min(node.val,min);
            int left=helper(node.left,max,min);
            int right=helper(node.right,max,min);
            return Math.max(left,right);
        
    }
}
