class Oct07264 {
    public static void main(String[] args) {
        Oct07264 oct = new Oct07264();
        int[] piles = { 3, 1, 2, 5, 7 };
        System.out.println("stone game--->" + oct.stoneGameII(piles));
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }

        int[][] dp = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if ((i + 2 * m) >= n) {
                    dp[i][m] = suffixSum[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        int oppBest = dp[i + x][Math.max(m, x)];
                        dp[i][m] = Math.max(dp[i][m], suffixSum[i] - oppBest);
                    }
                }
            }
        }
        return dp[0][1];
    }

}