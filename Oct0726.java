class Oct0726 {
    public static void main(String[] args) {
        int amount = 4;
        int[] coins = { 1, 2, 3 };
        Oct0726 oct = new Oct0726();
        System.out.println("change-->" + oct.change(amount, coins));
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}