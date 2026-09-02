public class Aug2326 {

    public static void main(String[] args) {
        int m = 3, n = 6;
        Aug2326 aug = new Aug2326();
        System.out.println("unique paths--->" + aug.uniquePaths(m, n));
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
