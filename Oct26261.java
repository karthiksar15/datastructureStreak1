public class Oct26261 {

    public static void main(String[] args) {
        Oct26261 oct = new Oct26261();
        int[] cost = { 1, 2, 3 };
        System.out.println("minCost-->" + oct.minCostClimbingStairs(cost));
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
