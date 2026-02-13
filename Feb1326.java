import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Feb1126 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 0 } };
        int k = 1;
        Feb1126 feb = new Feb1126();
        System.out.println("shortestPath--->" + feb.shortestPath(grid, k));
    }

    public int shortestPath(int[][] grid, int k) {
        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };
        Deque<int[]> queue = new LinkedList<>();
        queue.addLast(new int[] { 0, 0, 0 });
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int m = 0; m < size; m++) {
                int[] temp = queue.pollFirst();
                if (temp[0] == grid.length - 1 && temp[1] == grid[0].length) {
                    return temp[2];
                }
                for (int i = 0; i < dr.length; i++) {
                    int newRow = dr[i] + temp[0];
                    int newCol = dc[i] + temp[1];
                    int elim = temp[2];
                    if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                            && (!visited[newRow][newCol]) && elim <= k) {
                        if (grid[newRow][newCol] == 1) {
                            elim += 1;
                        }
                        queue.add(new int[] { newRow, newCol, elim });
                        visited[newRow][newCol] = true;
                    }
                }
            }
            count++;
        }
        return count;
    }

}
