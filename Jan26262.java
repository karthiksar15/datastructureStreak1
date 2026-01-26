public class Jan26262 {

    public static void main(String[] args) {
        Jan26262 jan = new Jan26262();
        char[][] grid = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println("num--->" + jan.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && (!seen[i][j])) {
                    dfs(i, j, seen, grid, count);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int i, int j, boolean[][] seen, char[][] mat, int count) {
        int[] row = { 1, 0, -1, 0 };
        int[] col = { 0, 1, 0, -1 };
        if (mat[i][j] == '0')
            return;
        seen[i][j] = true;
        for (int k = 0; k < row.length; k++) {
            int nextRow = i + row[k];
            int nextCol = j + col[k];
            if (nextRow >= 0 && nextRow < mat.length && nextCol >= 0 && nextCol < mat[0].length
                    && (!seen[nextRow][nextCol]))
                dfs(nextRow, nextCol, seen, mat, count);
        }

    }
}
