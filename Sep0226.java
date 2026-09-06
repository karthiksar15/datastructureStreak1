class Sep0226 {

    public static void main(String[] args) {
        int[] stones = { 3, 1, 2, 5, 7 };
        Sep0226 sep = new Sep0226();
        System.out.println("last stone--->" + sep.stoneGameII(stones));
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }

        int[][] dp = new int[n][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = suffixSum[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        int opponentBest = dp[i + x][Math.max(m, x)];
                        dp[i][m] = Math.max(dp[i][m], suffixSum[i] - opponentBest);
                    }
                }
            }
        }
        return dp[0][1];
    }
}

// o/p:
// +---------+-----+-----+-----+-----+-----+-----+
// | Index | 0 | 1 | 2 | 3 | 4 | 5 |
// +---------+-----+-----+-----+-----+-----+-----+
// | Row 0 | 0 | 10 | 11 | 18 | 18 | 18 |
// | Row 1 | 0 | 8 | 15 | 15 | 15 | 15 |
// | Row 2 | 0 | 7 | 14 | 14 | 14 | 14 |
// | Row 3 | 0 | 12 | 12 | 12 | 12 | 12 |
// | Row 4 | 0 | 7 | 7 | 7 | 7 | 7 |
// +---------+-----+-----+-----+-----+-----+-----+