public class Jan27 {

    int m, n;
    int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
    boolean[][] seen;

    public int numIslands(char[][] grid) {
        int ans = 0;
        m = grid.length;
        n = grid[0].length;
        seen = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1' && !seen[row][col]) {
                    ans++;
                    seen[row][col] = true;
                    dfs(row, col, grid);
                }

            }
        }
        return ans;
    }

    public boolean valid(int row, int cols, char[][] grid) {
        return 0 <= row && row < m && cols < n && 0 <= cols && grid[row][cols] == '1';
    }

    public void dfs(int row, int cols, char[][] grid) {
        for (int[] direction : directions) {
            int nextRow = row + direction[0], nextCol = cols + direction[1];
            if (valid(nextRow, nextCol, grid) && !seen[nextRow][nextCol]) {
                seen[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, grid);
            }
        }
    }

}
