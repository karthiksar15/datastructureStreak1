import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Feb15 {

    Map<Integer, List<Integer>> adj = new HashMap<>();
    boolean[] seen;

    public static void main(String[] args) {

        int[][] input = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        Feb15 feb = new Feb15();
        System.out.println("noofprovinces---" + feb.findCircleNum(input));

    }

    public int findCircleNum(int[][] isConnected) {

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    adj.computeIfAbsent(i, temp -> new ArrayList<>()).add(j);
                }
            }
        }
        int n = adj.size();
        this.seen = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!this.seen[i]) {
                ans += 1;
                this.seen[i] = true;
                dfs(i);
            }
        }
        return ans;
    }

    void dfs(int node) {

        for (int j : adj.get(node)) {
            if (!seen[j]) {
                seen[j] = true;
                dfs(j);
            }
        }
    }

}

