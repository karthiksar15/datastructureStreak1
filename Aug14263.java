public class Aug14263 {

    public static void main(String[] args) {
        int[] prices = { 1, 3, 4, 0, 4 };
        Aug14263 aug = new Aug14263();
        System.out.println("maxProfit---->" + aug.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                if (j == 1) {
                    int buy = dp[i + 1][0] - prices[i];
                    int cool = dp[i + 1][j];
                    dp[i][j] = Math.max(cool, buy);
                } else {
                    int sell = (i + 2) < n ? dp[i + 2][1] + prices[i] : prices[i];
                    int cool = dp[i + 1][j];
                    dp[i][j] = Math.max(sell, cool);
                }
            }
        }
        return dp[0][1];
    }
}
