import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jan26261 {

    public static void main(String[] args) {
        int[][] isConnected = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
        Jan26261 jan = new Jan26261();
        System.out.println("findCircleNum--->" + jan.findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    adj.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }
        boolean[] seen = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                count++;
                dfs(i, adj, seen);
            }
        }
        return count;
    }

    public void dfs(int i, Map<Integer, List<Integer>> adj, boolean[] seen) {
        if ((seen[i])) {
            return;
        }
        seen[i] = true;
        for (int j : adj.getOrDefault(i, new ArrayList<>())) {
            dfs(j, adj, seen);
        }
    }

}
