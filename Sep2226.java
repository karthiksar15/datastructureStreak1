public class Sep2226 {

    public static void main(String[] args) {
        Sep2226 sep = new Sep2226();
        int amount = 4;
        int[] coins = { 1, 2, 3 };
        System.out.println("coin change--->" + sep.change(amount, coins));
    }

    public int change(int amount, int[] coins) {
        int m = coins.length;
        int n = amount;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[m][amount];
    }

}
