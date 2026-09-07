class Sep0726 {
    public static void main(String[] args) {
        Sep0726 sep = new Sep0726();
        int m = 3, n = 6;
        System.out.println("unique paths--->" + sep.uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }
}

// o/p:
// 2D array
// +---------+-----+-----+-----+-----+-----+-----+-----+
// | Index | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
// +---------+-----+-----+-----+-----+-----+-----+-----+
// | Row 0 | 21 | 15 | 10 | 6 | 3 | 1 | 0 |
// | Row 1 | 6 | 5 | 4 | 3 | 2 | 1 | 0 |
// | Row 2 | 1 | 1 | 1 | 1 | 1 | 1 | 0 |
// | Row 3 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
// +---------+-----+-----+-----+-----+-----+-----+-----+
