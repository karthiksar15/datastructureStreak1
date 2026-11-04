
import java.util.LinkedList;
import java.util.Queue;

public class Nov03263 {

    public static void main(String[] args) {
        int[][] matrix = { { 5, 5, 3 }, { 2, 3, 6 }, { 1, 1, 1 } };
        Nov03263 nov = new Nov03263();
        System.out.println("LIP--->" + nov.longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] d = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        int[][] indegree = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int[] dd : d) {
                    int nr = dd[0] + i, nc = dd[1] + j;
                    if (nr >= 0 && nr < r && nc >= 0 && nc < c && matrix[i][j] > matrix[nr][nc]) {
                        indegree[i][j]++;
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
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
                for (int[] dr : d) {
                    int nr = dr[0] + temp[0];
                    int nc = dr[1] + temp[1];
                    if (nr >= 0 && nr < r && nc >= 0 && nc < c && matrix[nr][nc] > matrix[temp[0]][temp[1]]) {
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
