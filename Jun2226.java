import java.util.Arrays;

public class Jun2226 {

    public static void main(String[] args) {
        int[] cost = { 1, 2, 3 };
        Jun2226 jun = new Jun2226();
        System.out.println("mincost--->" + jun.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

}
