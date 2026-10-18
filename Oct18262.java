public class Oct18262 {

    public static void main(String[] args) {
        int[] cost = { 1, 2, 3 };
        Oct18262 oct = new Oct18262();
        System.out.println("minCost--->" + oct.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(cost[i - 2] + dp[i - 2], cost[i - 1] + dp[i - 1]);
        }
        return dp[n];
    }

}
