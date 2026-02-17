import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Feb1526 {

    public static void main(String[] args) {
        int n = 3;
        int[][] redEdges = { { 0, 1 }, { 1, 2 } }, blueEdges = {};
        Feb1526 feb = new Feb1526();
        Arrays.stream(feb.shortestAlternatingPaths(n, redEdges, blueEdges)).forEach(System.out::println);
    }

    // 1129. Shortest Path with Alternating Colors
    // BFS over state (node, lastColor). lastColor: 0=RED, 1=BLUE
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        final int RED = 0, BLUE = 1;

        // Build adjacency lists separated by color
        List<Integer>[] redAdj = new ArrayList[n];
        List<Integer>[] blueAdj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            redAdj[i] = new ArrayList<>();
            blueAdj[i] = new ArrayList<>();
        }
        for (int[] e : redEdges)
            redAdj[e[0]].add(e[1]);
        for (int[] e : blueEdges)
            blueAdj[e[0]].add(e[1]);

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        // seen[node][colorOfLastEdgeUsedToReachNode]
        boolean[][] seen = new boolean[n][2];
        Deque<int[]> q = new LinkedList<>(); // {node, color, dist}

        // Start from node 0 with both colors as virtual previous edge
        q.add(new int[] { 0, RED, 0 });
        q.add(new int[] { 0, BLUE, 0 });
        seen[0][RED] = true;
        seen[0][BLUE] = true;

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int node = cur[0], color = cur[1], dist = cur[2];
            ans[node] = Math.min(ans[node], dist);

            // Next edges must be opposite color
            if (color == RED) {
                for (int nei : blueAdj[node]) {
                    if (!seen[nei][BLUE]) {
                        seen[nei][BLUE] = true;
                        q.addLast(new int[] { nei, BLUE, dist + 1 });
                    }
                }
            } else { // last color BLUE, take RED edges next
                for (int nei : redAdj[node]) {
                    if (!seen[nei][RED]) {
                        seen[nei][RED] = true;
                        q.addLast(new int[] { nei, RED, dist + 1 });
                    }
                }
            }
        }

        for (int i = 0; i < n; i++)
            if (ans[i] == Integer.MAX_VALUE)
                ans[i] = -1;
        return ans;
    }

}

// class Solution {
// int RED = 0;
// int BLUE = 1;
// Map<Integer, Map<Integer, List<Integer>>> graph = new HashMap<>();
// public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][]
// blueEdges) {
// graph.put(RED, new HashMap<>());
// graph.put(BLUE, new HashMap<>());
// addToGraph(RED, redEdges, n);
// addToGraph(BLUE, blueEdges, n);

// int[] ans = new int[n];
// Arrays.fill(ans, Integer.MAX_VALUE);

// Queue<State> queue = new LinkedList<>();
// queue.add(new State(0, RED, 0));
// queue.add(new State(0, BLUE, 0));
// boolean[][] seen = new boolean[n][2];
// seen[0][RED] = true;
// seen[0][BLUE] = true;
// while (!queue.isEmpty()) {
// State state = queue.remove();
// int node = state.node, color = state.color, steps = state.steps;
// ans[node] = Math.min(ans[node], steps);

// for (int neighbor : graph.get(color).get(node)) {
// if (!seen[neighbor][1 - color]) {
// seen[neighbor][1 - color] = true;
// queue.add(new State(neighbor, 1 - color, steps + 1));
// }
// }
// }
// for (int i = 0; i < n; i++) {
// if (ans[i] == Integer.MAX_VALUE)
// ans[i] = -1;
// }
// return ans;

// }
// public void addToGraph(int color, int[][] edges, int len) {
// for (int i = 0; i < len; i++) {
// graph.get(color).put(i, new ArrayList<>());
// }
// for (int[] edge : edges) {
// graph.get(color).get(edge[0]).add(edge[1]);
// }
// }
// class State {
// int node;
// int color;
// int steps;

// State(int node, int color, int steps) {
// this.node = node;
// this.color = color;
// this.steps = steps;
// }
// }
// }
