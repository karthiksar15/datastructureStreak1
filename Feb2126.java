import java.util.Deque;
import java.util.LinkedList;

public class Feb1726 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        Feb1726 feb = new Feb1726();
        System.out.println("shortest path is --->" + feb.shortestPathBinaryMatrix(grid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0)
            return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && (!visited[i][j])) {
                    result = Math.min(result, bfs(i, j, grid, visited));
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int bfs(int i, int j, int[][] grid, boolean[][] visited) {
        int[] dr = { 0, 1, 0, -1, 1, -1, 1, -1 };
        int[] dc = { 1, 0, -1, 0, 1, -1, -1, 1 };
        Deque<int[]> queue = new LinkedList();
        queue.add(new int[] { i, j, 1 });
        int result = -1;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int d = 0; d < dr.length; d++) {
                int newRow = temp[0] + dr[d];
                int newCol = temp[1] + dc[d];
                int dist = temp[2];
                if (newRow == grid.length - 1 && newCol == grid[0].length - 1) {
                    visited[newRow][newCol] = true;
                    return dist + 1;
                }
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && grid[newRow][newCol] == 0 && (!visited[newRow][newCol])) {
                    queue.add(new int[] { newRow, newCol, dist + 1 });
                    visited[newRow][newCol] = true;
                }
            }

        }
        return result;
    }

}
