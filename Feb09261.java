import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Feb0926 {

    public static void main(String[] args) {
        Feb0926 feb = new Feb0926();
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
        TreeNode node8 = feb.new TreeNode(7);
        node3.left = node6;
        node3.right = node7;
        TreeNode node9 = feb.new TreeNode(4);
        node5.left = node8;
        node5.right = node9;
        System.out.println("distanceK--->" + feb.distanceK(node1, node2, 2));

    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, graph);
        Map<Integer, Integer> distanceMap = new HashMap<>();
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(target.x);
        Set<Integer> visited = new HashSet<>();
        visited.add(target.x);
        List<Integer> resultList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int temp = queue.removeFirst();
            int dist = distanceMap.getOrDefault(temp, 0);
            if (distanceMap.get(temp) != null && distanceMap.get(temp) == k) {
                resultList.add(temp);
            }
            for (int neigh : graph.get(temp)) {
                if (visited.add(neigh)) {
                    queue.addLast(neigh);
                    distanceMap.put(neigh, dist + 1);
                }
            }
        }
        return resultList;
    }

    public void buildGraph(TreeNode root, Map<Integer, List<Integer>> graph) {
        Deque<TreeNode> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.removeLast();
            if (temp.left != null) {
                graph.computeIfAbsent(temp.x, v -> new ArrayList<>()).add(temp.left.x);
                graph.computeIfAbsent(temp.left.x, v -> new ArrayList<>()).add(temp.x);
                stack.add(temp.left);
            }
            if (temp.right != null) {
                graph.computeIfAbsent(temp.x, v -> new ArrayList<>()).add(temp.right.x);
                graph.computeIfAbsent(temp.right.x, v -> new ArrayList<>()).add(temp.x);
                stack.add(temp.right);
            }
        }
    }

    class TreeNode {
        int x;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            this.x = x;
        }
    }

}
