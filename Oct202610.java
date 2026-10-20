import java.util.LinkedList;
import java.util.Queue;

public class Oct202610 {

    public static void main(String[] args) {
        int[][] matrix = { { 5, 5, 3 }, { 2, 3, 6 }, { 1, 1, 1 } };
        Oct202610 oct = new Oct202610();
        System.out.println("longest--->" + oct.longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        int[][] indgree = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : dir) {
                    int nr = i + d[0], nc = j + d[1];
                    if (nc >= 0 && nr >= 0 && nc < n && nr < m && matrix[i][j] > matrix[nr][nc]) {
                        indgree[i][j]++;
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (indgree[i][j] == 0) {
                    q.offer(new int[] { i, j });
                }
            }
        }
        int LIS = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int r = 0; r < size; r++) {
                int[] temp = q.poll();
                int i = temp[0], j = temp[1];
                for (int[] d : dir) {
                    int nr = i + d[0], nc = j + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[i][j]) {
                        if (--indgree[nr][nc] == 0) {
                            q.offer(new int[] { nr, nc });
                        }
                    }
                }
            }
            LIS++;
        }
        return LIS;
    }

}
