import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Map.Entry;

public class Jan24261 {

    public static void main(String[] args) {
        Jan24261 jan = new Jan24261();
        // int[][] bombs = { { 1, 2, 1 }, { 2, 3, 1 }, { 3, 4, 1 }, { 4, 5, 1 }, { 5, 6,
        // 6 } };
        // int[][] bombs = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6,
        // 4 } };
        // int[][] bombs = { { 1, 1, 5 }, { 10, 10, 5 } };
        // int[][] bombs = { { 2, 1, 3 }, { 6, 1, 4 } };
        int[][] bombs = { { 4, 4, 3 }, { 4, 4, 3 } };
        System.out.println("maximum detonation--->" + jan.maximumDetonation(bombs));
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        // Build directed adjacency list: edge i -> j if j within i's radius
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            long xi = bombs[i][0];
            long yi = bombs[i][1];
            long ri2 = (long) bombs[i][2] * bombs[i][2];

            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                long dx = xi - bombs[j][0];
                long dy = yi - bombs[j][1];
                long dist2 = dx * dx + dy * dy;
                if (dist2 <= ri2) {
                    adj[i].add(j);
                }
            }
        }

        int max = 0;
        boolean[] visited = new boolean[n];
        for (int start = 0; start < n; start++) {
            // BFS from start
            java.util.Arrays.fill(visited, false);
            Deque<Integer> q = new ArrayDeque<>();
            q.add(start);
            visited[start] = true;
            int count = 0;

            while (!q.isEmpty()) {
                int cur = q.poll();
                count++;
                for (int nxt : adj[cur]) {
                    if (!visited[nxt]) {
                        visited[nxt] = true;
                        q.add(nxt);
                    }
                }
            }
            if (count > max)
                max = count;
        }
        return max;
    }

}
