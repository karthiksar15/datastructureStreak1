import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jan26263 {

    public static void main(String[] args) {
        Jan26263 jan = new Jan26263();
        // int n = 6;
        // int[][] connections = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
        // int n=5;
        // int[][] connections = { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } };
        int n = 2;
        int[][] connections = { { 1, 0 }, { 2, 0 } };
        System.out.println("minOrder--->" + jan.minReorder(n, connections));
    }

    public int minReorder(int n, int[][] connections) {
        if (n <= 1)
            return 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < connections.length; i++) {
            graph.computeIfAbsent(connections[i][0], k -> new ArrayList<>()).add(connections[i][1]);
        }
        boolean[] seen = new boolean[n];
        // seen[0]=true;
        int[] cnt = new int[1];
        for (int i = 0; i < n; i++) {
            dfs(seen, graph, i, cnt);
        }
        return cnt[0];
    }

    public void dfs(boolean[] seen, Map<Integer, List<Integer>> graph, int i, int[] count) {
        seen[i] = true;
        for (Integer n : graph.getOrDefault(i, new ArrayList<>())) {
            if (!seen[n] && n == 0) {
                count[0] += 1;
                dfs(seen, graph, n, count);
            }
        }
    }
}
