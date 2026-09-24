import java.util.LinkedList;
import java.util.Queue;

public class Sep2426 {

    public static void main(String[] args) {
        Sep2426 sep = new Sep2426();
        int[][] matrix = { { 5, 5, 3 }, { 2, 3, 6 }, { 1, 1, 1 } };
        System.out.println("longest--->" + sep.longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] indegree = new int[row][col];
        int[][] directions = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < row && nc >= 0 && nc < col && matrix[r][c] > matrix[nr][nc]) {
                        indegree[r][c]++;
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (indegree[r][c] == 0) {
                    q.add(new int[] { r, c });
                }
            }
        }
        int LIS = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                int r = temp[0], c = temp[1];
                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < row && nc >= 0 && nc < col && matrix[nr][nc] > matrix[r][c]) {
                        if (--indegree[nr][nc] == 0) {
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
