import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Mar4 {

    public static void main(String[] args) {
        // Integer[] root = { 3, 5, 1, 6, 2, 0, 8, null, null, 7, 4 };
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(6);
        TreeNode node5 = new TreeNode(2);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(8);
        node3.left = node6;
        node3.right = node7;
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(4);
        node5.left = node8;
        node5.right = node9;
        int k = 2;
        Mar4 mar = new Mar4();
        System.out.println("List---->" + mar.distanceK(node1, node2, k));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(graph, root);
        List<Integer> result = new ArrayList<>();
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(target.val, 0));
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        while (!queue.isEmpty()) {
            State state = queue.poll();
            if (k == state.count) {
                result.add(state.key);
            }
            for (Integer map : graph.get(state.key)) {
                if (!visited.contains(map)) {
                    queue.add(new State(map, state.count + 1));
                    visited.add(map);
                }
            }
        }
        return result;
    }

    public void buildGraph(Map<Integer, List<Integer>> graph, TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp.left != null) {
                graph.computeIfAbsent(temp.val, k1 -> new ArrayList<>()).add(temp.left.val);
                graph.computeIfAbsent(temp.left.val, k1 -> new ArrayList<>()).add(temp.val);
                stack.push(temp.left);
            }
            if (temp.right != null) {
                graph.computeIfAbsent(temp.val, k1 -> new ArrayList<>()).add(temp.right.val);
                graph.computeIfAbsent(temp.right.val, k1 -> new ArrayList<>()).add(temp.val);
                stack.push(temp.right);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class State {
        Integer key;
        Integer count;

        State(int key, int count) {
            this.key = key;
            this.count = count;
        }
    }
}
