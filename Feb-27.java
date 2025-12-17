class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int shotest = -1;
        Queue<StateMat> queue = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        if (grid[0][0] != 0)
            return shotest;
        if (grid[0][0]==0 && grid.length==1)
            return 1;
        queue.add(new StateMat(0, 0, 1));
        visited[0][0]=true;
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { 1, 1 }, { -1, 1 }, { 1, -1 } };
        while (!queue.isEmpty()) {
            StateMat state = queue.poll();
            for (int[] direction : directions) {
                int nextRow = state.row + direction[0];
                int nextCol = state.col + direction[1];
                if (valid(nextRow, nextCol, grid) && (!visited[nextRow][nextCol])) {
                    visited[nextRow][nextCol] = true;
                    if(nextRow==grid.length-1 && nextCol==grid.length-1)
                    {
                        return state.count+1;
                    }
                    queue.add(new StateMat(nextRow, nextCol, state.count+1));
                }
            }
        }

        return shotest;
    }
    public boolean valid(int i, int j, int[][] grid) {
        return (i >= 0 && i < grid.length && j >= 0 && j < grid.length && grid[i][j] == 0);
    }

    class StateMat {
        int row;
        int col;
        int count;

        public StateMat(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
