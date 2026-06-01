import java.util.Arrays;

public class May31262 {

    int[][] dp;

    public static void main(String[] args) {
        May31262 may = new May31262();
        int[][] grid = {
                { 1, 2, 0 },
                { 5, 4, 2 },
                { 1, 1, 3 } };
        System.out.println("minPathSum--->" + may.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        for (int[] dp : dp) {
            Arrays.fill(dp, -1);
        }
        return dfs(grid, m, n, 0, 0);
    }

    public int dfs(int[][] grid, int m, int n, int r, int c) {
        if (r == m - 1 && c == n - 1)
            return grid[r][c];
        if (r == m || c == n)
            return 0;
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        dp[r][c] = grid[r][c] + Math.min(dfs(grid, m, n, r + 1, c), dfs(grid, m, n, r, c + 1));
        return dp[r][c];
    }

}
