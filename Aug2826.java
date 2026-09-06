class Aug2826 {
    public static void main(String[] args) {
        Aug2826 aug = new Aug2826();
        int[] prices = { 1, 3, 4, 0, 4 };
        System.out.println("maxProfit--->" + aug.maxProfit(prices));
    }
    // The problem on your screen, Best Time to Buy and Sell Stock with Cooldown, is
    // solved using a classic dynamic programming pattern known as State Machine (or
    // Multi-State DP).

    // Why the State Machine Pattern?
    // In standard dynamic programming problems, you typically make a single choice
    // at index i (e.g., take it or leave it). However, in stock problems with
    // constraints like cooldowns or transaction fees, your available actions depend
    // heavily on your current "state."

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

// o/p

// +---------+-----+-----+
// | Index | 0 | 1 |
// +---------+-----+-----+
// | Row 0 | 7 | 6 |
// | Row 1 | 7 | 4 |
// | Row 2 | 4 | 4 |
// | Row 3 | 4 | 4 |
// | Row 4 | 4 | 0 |
// | Row 5 | 0 | 0 |
// +---------+-----+-----+
