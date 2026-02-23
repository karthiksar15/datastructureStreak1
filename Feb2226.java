import java.util.Deque;
import java.util.LinkedList;

public class Feb2226 {

    public static void main(String[] args) {
        Feb2226 feb = new Feb2226();
        // int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0,
        // 0 } };
        int[][] grid = { { 0, 1, 1 }, { 1, 1, 1 }, { 1, 0, 0 } };
        int k = 1;
        System.out.println("shortest path--->" + feb.shortestPath(grid, k));
    }

    public int shortestPath(int[][] grid, int k) {
        if (grid[0][0] != 0)
            return -1;
        if (grid[0].length == 1 && grid[0][0] == 0)
            return 1;
        return bfs(grid, k);
    }

    public int bfs(int[][] grid, int k) {
        int result = Integer.MAX_VALUE / 2;
        Deque<int[]> queue = new LinkedList<>();
        queue.addLast(new int[] { 0, 0, 1, 1 });
        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        seen[0][0] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.pollFirst();
            for (int i = 0; i < dr.length; i++) {
                int newRow = temp[0] + dr[i];
                int newCol = temp[1] + dc[i];
                int dist = temp[2];
                int exm = temp[3];
                if (newRow == (grid.length - 1) && newCol == (grid[0].length - 1)) {
                    result = Math.min(dist, result);
                }
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && (!seen[newRow][newCol])
                        && ((exm <= k && grid[newRow][newCol] == 1) || (grid[newRow][newCol] == 0))) {
                    seen[newRow][newCol] = true;
                    queue.add(new int[] { newRow, newCol, dist + 1, exm + 1 });
                }
            }
        }
        return result == Integer.MAX_VALUE / 2 ? -1 : result;

    }

}
