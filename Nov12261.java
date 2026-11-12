public class Nov12261 {

    public static void main(String[] args) {
        int[] cost = { 1, 2, 3 };
        Nov12261 nov = new Nov12261();
        System.out.println("minCost-->" + nov.minCostClimbingStairs(cost));
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
