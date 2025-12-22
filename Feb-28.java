import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Feb27 {

    public static void main(String[] args) {

        Feb27 feb = new Feb27();
        TreeNode node1 = feb.new TreeNode(3);
        TreeNode node2 = feb.new TreeNode(5);
        TreeNode node3 = feb.new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = feb.new TreeNode(6);
        TreeNode node5 = feb.new TreeNode(2);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = feb.new TreeNode(0);
        TreeNode node7 = feb.new TreeNode(8);
        node3.left = node6;
        node3.right = node7;
        TreeNode node8 = feb.new TreeNode(7);
        TreeNode node9 = feb.new TreeNode(4);
        node5.left = node8;
        node5.right = node9;
        TreeNode target = feb.new TreeNode(5);
        System.out.println("Distance K are --->" + feb.distanceK(node1, target, 2));

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left != null) {
                adjList.computeIfAbsent(temp.val, mk -> new ArrayList<>()).add(temp.left.val);
                adjList.computeIfAbsent(temp.left.val, mk -> new ArrayList<>()).add(temp.val);
                stack.push(temp.left);
            }
            if (temp.right != null) {
                adjList.computeIfAbsent(temp.val, mj -> new ArrayList<>()).add(temp.right.val);
                adjList.computeIfAbsent(temp.right.val, mj -> new ArrayList<>()).add(temp.val);
                stack.push(temp.right);
            }
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer[]> queue = new LinkedList();
        visited.add(target.val);
        queue.add(new Integer[] { target.val, 0 });
        while (!queue.isEmpty()) {
            Integer[] num = queue.poll();
            int dist = num[1];
            if (dist == k)
                result.add(num[0]);
            if (Objects.nonNull(adjList.get(num[0]))) {
                for (Integer neig : adjList.get(num[0])) {
                    if (!visited.contains(neig)) {
                        queue.add(new Integer[] { neig, dist + 1 });
                        visited.add(neig);
                    }
                }
            }
        }

        return result;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}

