
import java.util.LinkedList;
import java.util.Queue;

public class Nov10263 {

    public static void main(String[] args) {
        int[][] matrix = { { 5, 5, 3 }, { 2, 3, 6 }, { 1, 1, 1 } };
        Nov10263 nov = new Nov10263();
        System.out.println("longest--->" + nov.longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] indegree = new int[m + 1][n + 1];
        int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : directions) {
                    int nr = d[0] + i;
                    int nc = d[1] + j;
                    if (nr < m && nr >= 0 && nc < n && nc >= 0 && matrix[i][j] > matrix[nr][nc]) {
                        indegree[i][j]++;
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (indegree[i][j] == 0) {
                    q.add(new int[] { i, j });
                }
            }
        }
        int lis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                int r = temp[0];
                int c = temp[1];
                for (int[] d : directions) {
                    int nr = temp[0] + d[0];
                    int nc = temp[1] + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && matrix[nr][nc] > matrix[r][c]) {
                        if (--indegree[nr][nc] == 0) {
                            q.add(new int[] { nr, nc });
                        }
                    }
                }
            }
            lis++;
        }
        return lis;
    }

}
