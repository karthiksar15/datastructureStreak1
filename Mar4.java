import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Mar2 {

    int RED = 0;
    int BLUE = 1;
    Map<Integer, Map<Integer, List<Integer>>> graph = new HashMap<>();

    public static void main(String[] args) {
        Mar2 mar = new Mar2();
        int n = 3;
        int[][] redEdges = { { 0, 1 } };
        int[][] blueEdges = { { 2, 1 } };
        Arrays.stream(mar.shortestAlternatingPaths(n, redEdges, blueEdges)).forEach(System.out::println);
        // System.out.println("shortest alter---->" + );
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        graph.put(RED, new HashMap<>());
        graph.put(BLUE, new HashMap<>());
        addToGraph(RED, redEdges, n);
        addToGraph(BLUE, blueEdges, n);

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);

        Queue<State> queue = new LinkedList<>();
        queue.add(new State(0, RED, 0));
        queue.add(new State(0, BLUE, 0));
        boolean[][] seen = new boolean[n][2];
        seen[0][RED] = true;
        seen[0][BLUE] = true;
        while (!queue.isEmpty()) {
            State state = queue.remove();
            int node = state.node, color = state.color, steps = state.steps;
            ans[node] = Math.min(ans[node], steps);

            for (int neighbor : graph.get(color).get(node)) {
                if (!seen[neighbor][1 - color]) {
                    seen[neighbor][1 - color] = true;
                    queue.add(new State(neighbor, 1 - color, steps + 1));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE)
                ans[i] = -1;
        }
        return ans;
    }

    public void addToGraph(int color, int[][] edges, int len) {
        for (int i = 0; i < len; i++) {
            graph.get(color).put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(color).get(edge[0]).add(edge[1]);
        }
    }

    class State {
        int node;
        int color;
        int steps;

        State(int node, int color, int steps) {
            this.node = node;
            this.color = color;
            this.steps = steps;
        }
    }

}
