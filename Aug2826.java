class Aug2826 {
    public static void main(String[] args) {
        Aug2826 aug = new Aug2826();
        int[] prices = { 1, 3, 4, 0, 4 };
        System.out.println("maxProfit--->" + aug.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                if (j == 1) {
                    int buying = dp[i + 1][0] - prices[i];
                    int cooling = dp[i + 1][j];
                    dp[i][j] = Math.max(cooling, buying);
                } else {
                    int selling = i + 2 < n ? dp[i + 2][1] + prices[i] : prices[i];
                    int cooling = dp[i + 1][j];
                    dp[i][j] = Math.max(selling, cooling);
                }
            }
        }
        return dp[0][1];
    }
}
