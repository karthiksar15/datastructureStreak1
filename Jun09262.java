public class Jun09262 {

    public static void main(String[] args) {

        Jun09262 jun = new Jun09262();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println("maxProfit--->" + jun.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length + 1][2];
        for (int i = prices.length - 1; i >= 0; i--) {
            dp[i][0] = Math.max(dp[i + 1][0], -prices[i] + dp[i + 1][1]);
            dp[i][1] = Math.max(dp[i + 1][1], prices[i] + dp[i + 1][0]);
        }
        return dp[0][0];
    }

}
