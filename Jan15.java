import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Jan22 {

    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 3, 9, 20, 15, null, 7 };
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        TreeNode node5 = new TreeNode(7);
        node3.right = node5;
        System.out.println(printZigZag(node1));
    }

    public static List<List<Integer>> printZigZag(TreeNode root) {
        List<List<Integer>> list1 = new ArrayList<>();
        if (root == null)
            return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        int start = 1;
        nextStack.push(root);
        while (!nextStack.isEmpty()) {
            stack = (Stack<Jan22.TreeNode>) nextStack.clone();
            nextStack.clear();
            List<Integer> list = new ArrayList<>();
            while (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                list.add(temp.val);
                if (start == 1) {
                    if (temp.left != null)
                        nextStack.push(temp.left);
                    if (temp.right != null)
                        nextStack.push(temp.right);
                } else {
                    if (temp.right != null)
                        nextStack.push(temp.right);
                    if (temp.left != null)
                        nextStack.push(temp.left);
                }
            }
            if (start == 1)
                start = -1;
            else
                start = 1;
            list1.add(list);
        }

        return list1;
    }

    static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}

