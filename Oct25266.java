public class Oct25266 {

    public static void main(String[] args) {
        Oct25266 oct = new Oct25266();
        int[] nums = { 4, 2, 3, 7 };
        System.out.println("maxCoins-->" + oct.maxCoins(nums));
    }

    public int maxCoins(int[] coins) {
        int n = coins.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = coins[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int l = n; l >= 1; l--) {
            for (int r = l; r <= n; r++) {
                for (int i = l; i <= r; i++) {
                    int cost = newNums[l - 1] * newNums[i] * newNums[r + 1];
                    cost += dp[l][i - 1] + dp[i + 1][r];
                    dp[l][r] = Math.max(dp[l][r], cost);

                }
            }
        }
        return dp[1][n];
    }

}
