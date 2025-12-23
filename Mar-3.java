import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Feb28 {

    public static void main(String[] args) {
        Feb28 feb = new Feb28();
        // int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] mat = { { 1, 0, 1, 1, 0, 0, 1, 0, 0, 1 }, { 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 1, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
                { 0, 0, 1, 0, 1, 1, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 } };
        int[][] result = feb.updateMatrix(mat);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>();

        final int INF = Integer.MAX_VALUE / 2;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new int[] { i, j });
                } else {
                    dist[i][j] = INF;
                }

            }
        }
        // Directions: right, left, down, up
        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (dist[nr][nc] > dist[r][c] + 1) {
                        dist[nr][nc] = dist[r][c] + 1;
                        q.offer(new int[] { nr, nc });
                    }
                }
            }
        }
        return dist;
    }

    // public int[][] updateMatrix(int[][] mat) {
    // int[][] result = new int[mat.length][mat[0].length];
    // for (int i = 0; i < mat.length; i++) {
    // for (int j = 0; j < mat[0].length; j++) {
    // if (mat[i][j] == 1)
    // result[i][j] = validate(i, j, mat);
    // }
    // }
    // return result;
    // }

    // public int validate(int row, int column, int[][] mat) {
    // int[] rows = { 0, -1, 1, 0 };
    // int[] cols = { 1, 0, 0, -1 };
    // int result = Integer.MAX_VALUE;
    // Queue<Integer[]> queue = new LinkedList<>();
    // boolean[][] visited = new boolean[mat.length][mat[0].length];
    // queue.add(new Integer[] { row, column, 1 });
    // visited[row][column] = true;
    // while (!queue.isEmpty()) {
    // Integer[] temp = queue.poll();
    // row = temp[0];
    // column = temp[1];
    // int count = temp[2];
    // for (int j = 0; j < rows.length; j++) {
    // int nextRow = row + rows[j];
    // int nextCol = column + cols[j];
    // if (nextRow >= 0 && nextRow < mat.length && nextCol >= 0 && nextCol <
    // mat[0].length
    // && mat[nextRow][nextCol] == 0) {
    // result = Math.min(count, result);
    // } else if (nextRow >= 0 && nextRow < mat.length && nextCol >= 0 && nextCol <
    // mat[0].length
    // && mat[nextRow][nextCol] == 1 && (!visited[nextRow][nextCol])) {
    // queue.add(new Integer[] { nextRow, nextCol, count + 1 });
    // }
    // visited[row][column] = true;
    // }
    // }
    // return result == Integer.MAX_VALUE ? -1 : result;
    // }

}
