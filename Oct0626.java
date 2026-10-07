class Oct0626 {
    public static void main(String[] args) {
        int[] prices = { 1, 3, 4, 0, 4 };
        Oct0626 oct = new Oct0626();
        System.out.println("maxProfit--->" + oct.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                if (j == 1) {
                    int buy = dp[i + 1][0] - prices[i];
                    int cooldown = dp[i + 1][j];
                    dp[i][j] = Math.max(cooldown, buy);
                } else {
                    int sell = i + 2 < n ? dp[i + 2][1] + prices[i] : prices[i];
                    int cooldown = dp[i + 1][j];
                    dp[i][j] = Math.max(sell, cooldown);
                }
            }
        }
        return dp[0][1];
    }
}