import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Nov14269 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[] root = { 1, 2, 3, 4, 5, 6, 7 };
        Nov14269 nov = new Nov14269();
        TreeNode node1 = nov.new TreeNode(1);
        TreeNode node2 = nov.new TreeNode(2);
        TreeNode node3 = nov.new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = nov.new TreeNode(4);
        TreeNode node5 = nov.new TreeNode(5);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = nov.new TreeNode(6);
        TreeNode node7 = nov.new TreeNode(7);
        node3.left = node6;
        node3.right = node7;
        System.out.println("postorder--->" + nov.postorderTraversal(node1));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        TreeNode curr = root;
        while (curr != null || (!stack.isEmpty())) {
            if (curr != null) {
                result.add(curr.val);
                stack.push(curr);
                curr = curr.right;
            } else {
                curr = stack.pop();
                curr = curr.left;
            }
        }
        Collections.reverse(result);
        return result;
    }

}
