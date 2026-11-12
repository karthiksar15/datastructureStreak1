public class Nov12268 {

    public static void main(String[] args) {
        Nov12268 nov = new Nov12268();
        System.out.println("unique-->" + nov.uniquePaths(3, 6));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
            }
        }
        return dp[0][0];
    }

}
