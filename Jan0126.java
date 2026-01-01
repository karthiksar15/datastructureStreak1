import java.util.LinkedList;
import java.util.Queue;

public class Jan0126 {

    public static void main(String[] args) {
        // char[][] maze = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+',
        // '+', '+' } };
        char[][] maze = { { '+', '+', '+' }, { '.', '.', '.' }, { '+', '+', '+' } };
        // int[] entrance = { 1, 2 };
        int[] entrance = { 1, 0 };
        Jan0126 jan = new Jan0126();
        System.out.println("Jan----" + jan.nearestExit(maze, entrance));
    }

    public int nearestExit(char[][] maze, int[] entrance) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(entrance[0], entrance[1], 0));
        visited[entrance[0]][entrance[1]] = true;
        while (!queue.isEmpty()) {
            State temp = queue.poll();
            int row = temp.row;
            int col = temp.col;
            int count = temp.count;
            for (int[] direction : directions) {
                int nextRow = row + direction[0];
                int nextCol = col + direction[1];
                if (isValid(nextRow, nextCol, maze)) {
                    if ((!visited[nextRow][nextCol]) && isBorder(nextRow, nextCol, maze))
                        return count + 1;
                    else if (!visited[nextRow][nextCol]) {
                        queue.add(new State(nextRow, nextCol, count + 1));
                        visited[nextRow][nextCol] = true;
                    }
                }
            }
        }
        return -1;
    }

    public boolean isValid(int row, int col, char[][] grid) {
        return (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length);
    }

    public boolean isBorder(int row, int col, char[][] grid) {
        return (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) && (grid[row][col] == '.');
    }

    class State {
        int row;
        int col;
        int count;

        public State(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
