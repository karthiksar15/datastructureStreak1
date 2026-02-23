import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Feb1926 {

    public static void main(String[] args) {
        Feb1926 feb = new Feb1926();
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node8;
        node5.right = node9;
        node3.left = node6;
        node3.right = node7;
        System.out.println("distanceK--->" + feb.distanceK(node1, node2, 2));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> map = new HashMap();
        buildGraph(root, map);
        Deque<int[]> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        set.add(target.val);
        queue.add(new int[] { target.val, 0 });
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[1] == k) {
                result.add(temp[0]);
                continue;
            }
            for (int neigh : map.getOrDefault(temp[0], new ArrayList<>())) {
                if (set.add(neigh)) {
                    queue.add(new int[] { neigh, temp[1] + 1 });
                }
            }

        }
        return result;

    }

    public void buildGraph(TreeNode root, Map<Integer, List<Integer>> map) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                map.computeIfAbsent(node.val, v -> new ArrayList<>()).add(node.left.val);
                map.computeIfAbsent(node.left.val, v -> new ArrayList<>()).add(node.val);
                stack.add(node.left);
            }
            if (node.right != null) {
                map.computeIfAbsent(node.val, v -> new ArrayList<>()).add(node.right.val);
                map.computeIfAbsent(node.right.val, v -> new ArrayList<>()).add(node.val);
                stack.add(node.right);
            }
        }
    }

}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
