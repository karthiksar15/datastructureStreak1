import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Feb17 {

    public static void main(String[] args) {
        // int[][] pts = { { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 } };
        // int n=6;
        // int[][] pts = { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } };
        // int n = 5;
        // int[][] pts = { { 1, 0 }, { 2, 0 } };
        // int n = 3;
        // int[][] pts = { { 0, 6 }, { 6, 3 }, { 1, 3 }, { 2, 1 }, { 4, 0 }, { 4, 5 } };
        // int n = 7;
        int[][] pts = { { 4, 3 }, { 2, 3 }, { 1, 2 }, { 1, 0 } };
        int n = 5;
        Feb17 feb = new Feb17();
        System.out.println("minorder is-->" + feb.minReorder(n, pts));
    }

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++)
            al.add(new ArrayList<>());
        for (var c : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }

        return dfs(al, new boolean[n], 0);
    }

    public int dfs(List<List<Integer>> adjList, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (var to : adjList.get(from)) {
            if (!visited[Math.abs(to)]) {
                change += dfs(adjList, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
            }
        }
        return change;
    }
}

