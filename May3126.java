import java.util.Arrays;

public class May3126 {

    int[][] memo;

    public static void main(String[] args) {
        May3126 may = new May3126();
        int m = 3, n = 6;
        System.out.println("unique paths--->" + may.uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int[] it : memo) {
            Arrays.fill(it, -1);
        }
        return dfs(0, 0, m, n);
    }

    public int dfs(int i, int j, int m, int n) {
        if (i == (m - 1) && j == (n - 1))
            return 1;
        if (i >= m || j >= n)
            return 0;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        memo[i][j] = dfs(i + 1, j, m, n) + dfs(i, j + 1, m, n);
        return memo[i][j];
    }

}
