public class Aug13261 {

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 2, 0 },
                { 5, 4, 2 },
                { 1, 1, 3 }
        };
        Aug13261 aug = new Aug13261();
        System.out.println("minPath--->" + aug.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];

        dp[m][n - 1] = 
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

}
