public class Oct172612 {

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 1, 0 } };
        Oct172612 oct = new Oct172612();
        System.out.println("uniquePath-->" + oct.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid[0].length;
        int n = obstacleGrid.length;
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] += dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
