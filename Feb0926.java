import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Feb0926 {
    public static void main(String[] args) {
        // int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        // int[][] grid = { { 1, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        int[][] grid = { { 0, 1 }, { 1, 0 } };
        Feb0826 feb = new Feb0826();
        System.out.println("shortestPathBinaryMatrix-->" + feb.shortestPathBinaryMatrix(grid));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int result = Integer.MAX_VALUE;

        int isValid = bfs(0, 0, grid);
        if (isValid > 0) {
            result = Math.min(isValid, result);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int bfs(int i, int k, int[][] grid) {
        int[] rows = { 0, -1, 1, 0, -1, 1, -1, 1 };
        int[] cols = { -1, 0, 0, 1, 1, -1, -1, 1 };
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, k });
        boolean[][] visited = new boolean[grid.length][grid.length];
        visited[i][k] = true;
        int count = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int m = 0; m < size; m++) {
                int[] temp = queue.poll();
                if (temp[0] == grid.length - 1 && temp[1] == grid.length - 1) {
                    return count;
                }
                for (int j = 0; j < rows.length; j++) {
                    int newRow = temp[0] + rows[j];
                    int newCol = temp[1] + cols[j];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid.length
                            && grid[newRow][newCol] == 0 && (!visited[newRow][newCol])) {
                        queue.add(new int[] { newRow, newCol });
                        visited[newRow][newCol] = true;
                    }

                }
            }
            count++;
        }
        return -1;
    }

}
