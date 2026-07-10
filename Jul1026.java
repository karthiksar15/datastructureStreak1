public class Jul1026 {

    public static void main(String[] args) {
        int[] prices = { 1, 3, 4, 0, 4 };
        Jul1026 jul = new Jul1026();
        System.out.println("maxProfit--->" + jul.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                if (j == 1) {
                    int buy = dp[i + 1][0] - prices[i];
                    int coolOff = dp[i + 1][1];
                    dp[i][1] = Math.max(coolOff, buy);
                } else {
                    int sell = dp[i + 1][1] + prices[i];
                    int coolOff = dp[i + 1][0];
                    dp[i][0] = Math.max(sell, coolOff);
                }
            }
        }
        return dp[0][1];
    }

}
