public class Jul09264 {

    public static void main(String[] args) {
        int[] prices = { 1, 3, 4, 0, 4 };
        Jul09264 jul = new Jul09264();
        System.out.println("maxProfit--->" + jul.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 1; buy >= 0; buy--) {
                if (buy == 1) {
                    int b = dp[i + 1][0] - prices[i];
                    int cooldown = dp[i + 1][1];
                    dp[i][1] = Math.max(cooldown, b);
                } else {
                    int s = (i + 2 < n) ? dp[i + 2][1] + prices[i] : prices[i];
                    int cooldown = dp[i + 1][0];
                    dp[i][0] = Math.max(cooldown, s);
                }
            }
        }
        return dp[0][1];
    }

}
