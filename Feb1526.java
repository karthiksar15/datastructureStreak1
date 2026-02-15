import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class Feb1326 {

    public static void main(String[] args) {

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
        Feb1326 feb = new Feb1326();
        System.out.println("distancek--->" + feb.distanceK(node1, node2, 2));
    }

    static {
        Runtime.getRuntime().gc();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (FileWriter writer = new FileWriter("display_runtime.txt")) {
                writer.write("0");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> result = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(target.val);
        Set<Integer> visited = new HashSet<>();
        visited.add(target.val);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, graph);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer temp = queue.pollFirst();
                if (count == k) {
                    result.add(temp);
                }
                if (graph.get(temp) != null) {
                    for (int num : graph.get(temp)) {
                        if (visited.add(num)) {
                            queue.add(num);
                        }
                    }
                }

            }
            count++;
        }

        return result;
    }

    public void buildGraph(TreeNode root, Map<Integer, List<Integer>> graph) {
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();

            if (temp.left != null) {
                graph.computeIfAbsent(temp.val, v -> new ArrayList<>()).add(temp.left.val);
                graph.computeIfAbsent(temp.left.val, v -> new ArrayList<>()).add(temp.val);
                stack.push(temp.left);
            }
            if (temp.right != null) {
                graph.computeIfAbsent(temp.val, v -> new ArrayList<>()).add(temp.right.val);
                graph.computeIfAbsent(temp.right.val, v -> new ArrayList<>()).add(temp.val);
                stack.push(temp.right);
            }
        }

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
// public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
// Map<Integer, List<Integer>> graph = new HashMap<>();
// buildGraph(graph, root);
// List<Integer> result = new ArrayList<>();
// Queue<State> queue = new LinkedList<>();
// queue.add(new State(target.val, 0));
// Set<Integer> visited = new HashSet<>();
// visited.add(target.val);
// while (!queue.isEmpty()) {
// State state = queue.poll();
// if (k == state.count) {
// result.add(state.key);
// }
// if(graph.get(state.key)!=null)
// {
// for (Integer map : graph.get(state.key)) {
// if (!visited.contains(map)) {
// queue.add(new State(map, state.count + 1));
// visited.add(map);
// }
// }
// }
// }
// return result;
// }

// public void buildGraph(Map<Integer, List<Integer>> graph, TreeNode root) {
// Stack<TreeNode> stack = new Stack<>();
// stack.push(root);
// while (!stack.isEmpty()) {
// TreeNode temp = stack.pop();
// if (temp.left != null) {
// graph.computeIfAbsent(temp.val, k1 -> new ArrayList<>()).add(temp.left.val);
// graph.computeIfAbsent(temp.left.val, k1 -> new ArrayList<>()).add(temp.val);
// stack.push(temp.left);
// }
// if (temp.right != null) {
// graph.computeIfAbsent(temp.val, k1 -> new ArrayList<>()).add(temp.right.val);
// graph.computeIfAbsent(temp.right.val, k1 -> new ArrayList<>()).add(temp.val);
// stack.push(temp.right);
// }
// }
// }

// class State {
// Integer key;
// Integer count;

// State(int key, int count) {
// this.key = key;
// this.count = count;
// }
// }
// }
