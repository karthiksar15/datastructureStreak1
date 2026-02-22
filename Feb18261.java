import java.util.Deque;
import java.util.LinkedList;

public class Feb1826 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        Feb1826 feb = new Feb1826();
        System.out.println("shortest path is --->" + feb.shortestPathBinaryMatrix(grid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0)
            return -1;
        if (grid[0].length == 1 && grid[0][0] == 0)
            return 1;
        int result = bfs(0, 0, grid);
        return result;
    }

    public int bfs(int i, int j, int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = Integer.MAX_VALUE;
        int[] dr = { 0, -1, 1, 0, -1, 1, -1, 1 };
        int[] dc = { -1, 0, 0, 1, -1, 1, 1, -1 };
        visited[i][j] = true;
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j, 1 });
        while (!queue.isEmpty()) {
            int[] temp = queue.pollFirst();
            int row = temp[0];
            int col = temp[1];
            int count = temp[2];
            for (int k = 0; k < dr.length; k++) {
                int newRow = row + dr[k];
                int newCol = col + dc[k];

                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && (!visited[newRow][newCol]) && grid[newRow][newCol] == 0) {
                    visited[newRow][newCol] = true;
                    if (newRow == grid.length - 1 && newCol == grid[0].length - 1) {
                        result = Math.min(result, count + 1);
                        continue;
                    }
                    queue.add(new int[] { newRow, newCol, count + 1 });
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
