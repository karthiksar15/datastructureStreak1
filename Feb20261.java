import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Feb2026 {

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        Feb2026 feb = new Feb2026();
        Arrays.stream(feb.updateMatrix(mat)).forEach(row -> System.out.println(Arrays.toString(row)));
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0 && (!visited[i][j])) {
                    visited[i][j] = true;
                    bfs(i, j, dist, visited, mat);
                }

            }
        }
        return dist;
    }

    public void bfs(int i, int j, int[][] dist, boolean[][] visited, int[][] mat) {
        int[] dr = { 0, -1, 1, 0 };
        int[] dc = { -1, 0, 0, 1 };
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j, 1 });
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int k = 0; k < dr.length; k++) {
                int newRow = temp[0] + dr[k];
                int newCol = temp[1] + dc[k];
                int distance = temp[2];
                if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length
                        && mat[newRow][newCol] == 1 && (distance < dist[newRow][newCol] || dist[newRow][newCol] == 0)) {
                    dist[newRow][newCol] = temp[2];
                    visited[newRow][newCol] = true;
                    queue.add(new int[] { newRow, newCol, distance + 1 });
                }

            }
        }
    }

}
