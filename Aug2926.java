import java.util.Arrays;

class Aug2926 {
    public static void main(String[] args) {
        int amount = 4;
        int[] coins = { 1, 2, 3 };
        Aug2926 aug = new Aug2926();
        System.out.println("change--->" + aug.change(amount, coins));
    }

    // However, Coin Change II is an unbounded knapsack problem where you have an
    // unlimited number of each coin. To allow picking the same coin multiple times,
    // you must look at the result of using the same coin for the remaining amount,
    // which requires dp[i][j - coins[i - 1]] (referencing the current row i rather
    // than the previous row i - 1).

    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[n][amount];
    }
}

// o/p:
// 2D array
// +---------+-----+-----+-----+-----+-----+
// | Index | 0 | 1 | 2 | 3 | 4 |
// +---------+-----+-----+-----+-----+-----+
// | Row 0 | 1 | 0 | 0 | 0 | 0 |
// | Row 1 | 1 | 1 | 1 | 1 | 1 |
// | Row 2 | 1 | 1 | 2 | 2 | 3 |
// | Row 3 | 1 | 1 | 2 | 3 | 4 |
// +---------+-----+-----+-----+-----+-----+
