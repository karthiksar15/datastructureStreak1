 int result = -1;
        if (grid[0][0] != 0)
            return result;
        Queue<State> queue = new LinkedList();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        queue.add(new State(0, 0, 1));
        return findAll(queue, visited, grid);
    }

    public int findAll(Queue<State> queue, boolean[][] visited, int[][] grid) {
        int count = Integer.MAX_VALUE;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, 1 }, { 1, -1 } };
        while (!queue.isEmpty()) {
            State temp = queue.poll();
            if (temp.row == grid.length - 1 && temp.col == grid[0].length - 1) {
                count = Math.min(count, temp.count);
            }
            for (int i = 0; i < directions.length; i++) {
                int nextRow = temp.row + directions[i][0];
                int nextCol = temp.col + directions[i][1];
                if (valid(nextRow, nextCol, grid) && (!visited[nextRow][nextCol])) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new State(nextRow, nextCol, temp.count + 1));
                }
            }

        }
        return count == Integer.MAX_VALUE ? -1 : count;
    }

    public boolean valid(int row, int col, int[][] grid) {
        if (row >= 0 && row < grid.length && col >= 0 && col < grid.length && grid[row][col] == 0)
            return true;
        return false;
    }

    class State {
        public int row;
        public int col;
        public int count;

        public State(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }

    }
