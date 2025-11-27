public class Feb16 {

    boolean seen[][];

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        Feb16 feb = new Feb16();
        System.out.println("number of islands-->" + feb.numIslands(grid));

    }

    public int numIslands(char[][] grid) {
        int ans = 0;
        this.seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!seen[i][j] && grid[i][j] == '1') {
                    seen[i][j] = true;
                    ans += 1;
                    dfs(i, j, grid);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, char[][] grid) {
        int[][] neigh = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int m = 0; m < neigh.length; m++) {
            int nextRow = i + neigh[m][0];
            int nextCol = j + neigh[m][1];
            if (isValid(nextRow, nextCol, grid.length, grid[0].length)
                    && (!seen[nextRow][nextCol])
                    && grid[nextRow][nextCol] == '1') {
                seen[nextRow][nextCol] = true;
                dfs(nextRow, nextCol, grid);
            }
        }
    }

    public boolean isValid(int row, int col, int rowLen, int colLen) {
        return (row < rowLen && col < colLen && row >= 0 && col >= 0);
    }

}

