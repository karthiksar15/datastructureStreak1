import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Feb1426 {

    public static void main(String[] args) {
        Feb1426 feb = new Feb1426();
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 0 } };
        System.out.println("updatedMatrix--->"
                + Arrays.stream(feb.updateMatrix(mat)).map(Arrays::toString).collect(Collectors.joining(",")));
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] distance = new int[mat.length][mat[0].length];
        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[] { i, j, 1 });
                    visited[i][j] = true;
                    bfs(mat, queue, visited, distance);
                }

            }
        }
        return distance;

    }

    public void bfs(int[][] mat, Deque<int[]> queue, boolean[][] visited, int[][] dist) {
        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };
        while (!queue.isEmpty()) {
            int[] temp = queue.pollFirst();
            int c = 0;
            for (int r : dr) {
                int newRow = temp[0] + r;
                int newCol = temp[1] + dc[c];
                int distance = temp[2];
                if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length
                        && mat[newRow][newCol] == 1 && (distance < dist[newRow][newCol] || dist[newRow][newCol] == 0)) {
                    dist[newRow][newCol] = temp[2];
                    visited[newRow][newCol] = true;
                    queue.add(new int[] { newRow, newCol, distance + 1 });
                }
                c++;
            }

        }
    }

}

// class Solution {
// public int[][] updateMatrix(int[][] mat) {
// int m = mat.length;
// int n = mat[0].length;
// int[][] dist = new int[m][n];
// Queue<int[]> q = new ArrayDeque<>();

// final int INF = Integer.MAX_VALUE / 2;
// for (int i = 0; i < m; i++) {
// for (int j = 0; j < n; j++) {
// if (mat[i][j] == 0) {
// dist[i][j] = 0;
// q.offer(new int[] { i, j });
// } else {
// dist[i][j] = INF;
// }

// }
// }
// // Directions: right, left, down, up
// int[] dr = { 0, 0, 1, -1 };
// int[] dc = { 1, -1, 0, 0 };

// while (!q.isEmpty()) {
// int[] cell = q.poll();
// int r = cell[0], c = cell[1];
// for (int k = 0; k < 4; k++) {
// int nr = r + dr[k];
// int nc = c + dc[k];
// if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
// if (dist[nr][nc] > dist[r][c] + 1) {
// dist[nr][nc] = dist[r][c] + 1;
// q.offer(new int[] { nr, nc });
// }
// }
// }
// }
// return dist;
// }

// }
