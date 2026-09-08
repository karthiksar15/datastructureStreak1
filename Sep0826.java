public class Sep0826 {

    public static void main(String[] args) {
        int[] prices = { 1, 3, 4, 0, 4 };
        Sep0826 sep = new Sep0826();
        System.out.println("maxProfit--->" + sep.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                if (j == 1) {
                    int buy = dp[i + 1][j - 1] - prices[i];
                    int cool = dp[i + 1][j];
                    dp[i][j] = Math.max(cool, buy);
                } else {
                    int sell = (i + 2) < n ? dp[i + 2][j + 1] + prices[i] : prices[i];
                    int cool = dp[i + 1][j];
                    dp[i][j] = Math.max(sell, cool);
                }
            }
        }
        return dp[0][1];
    }
}
