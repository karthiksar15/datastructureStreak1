public class May31261 {

    int[][] memo;

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 1, 0 } };
        May31261 may = new May31261();
        System.out.println("unique---->" + may.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;
        memo = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                memo[i][j] = -1;
            }
        }
        return dfs(0, 0, obstacleGrid, M, N);
    }

    public int dfs(int r, int c, int[][] grid, int M, int N) {

        if (r == M || c == N || grid[r][c] == 1)
            return 0;
        if (r == M - 1 && c == N - 1)
            return 1;
        if (memo[r][c] != -1)
            return memo[r][c];
        memo[r][c] = dfs(r + 1, c, grid, M, N) + dfs(r, c + 1, grid, M, N);
        return memo[r][c];
    }

}
