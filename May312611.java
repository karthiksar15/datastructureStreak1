import java.util.Arrays;

public class May312611 {

    int[][] dp;
    int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public static void main(String[] args) {
        int[][] matrix = { { 5, 5, 3 }, { 2, 3, 6 }, { 1, 1, 1 } };
        May312611 may = new May312611();
        System.out.println("longest--->" + may.longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lip = 0;
        dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                lip = Math.max(lip, dfs(matrix, r, c, Integer.MIN_VALUE, m, n));
            }
        }
        return lip;
    }

    public int dfs(int[][] mat, int r, int c, int prevVal, int m, int n) {
        if (r < 0 || r >= m || c < 0 || c >= n || mat[r][c] <= prevVal) {
            return 0;
        }
        if (dp[r][c] != -1)
            return dp[r][c];
        int res = 1;
        for (int[] d : directions) {
            res = Math.max(res, 1 + dfs(mat, r + d[0], c + d[1], mat[r][c], m, n));
        }
        return dp[r][c] = res;
    }

}
