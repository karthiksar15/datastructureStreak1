public class Oct12264 {

    public static void main(String[] args) {
        int[] prices = { 1, 3, 4, 0, 4 };
        Oct12264 oct = new Oct12264();
        System.out.println("maxProfit-->" + oct.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                if (j == 1) {
                    int buying = dp[i + 1][0] - prices[i];
                    int off = dp[i + 1][j];
                    dp[i][j] = Math.max(buying, off);
                } else {
                    int selling = i + 2 < n ? dp[i + 2][1] + prices[i] : prices[i];
                    int off = dp[i + 1][j];
                    dp[i][j] = Math.max(selling, off);
                }
            }
        }
        return dp[0][1];
    }

}
