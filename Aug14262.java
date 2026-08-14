public class Aug14262 {

    public static void main(String[] args) {
        int[] prices = { 1, 3, 4, 0, 4 };
        Aug14262 aug = new Aug14262();
        System.out.println("maxProfit---->" + aug.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int buying = 1; buying >= 0; buying--) {
                if (buying == 1) {
                    int buy = dp[i + 1][0] - prices[i];
                    int cool = dp[i + 1][1];
                    dp[i][buying] = Math.max(buy, cool);
                } else {
                    int sell = (i + 2 < n) ? dp[i + 2][1] + prices[i] : prices[i];
                    int cooldown = dp[i + 1][0];
                    dp[i][0] = Math.max(cooldown, sell);
                }
            }
        }
        return dp[0][1];
    }

}
