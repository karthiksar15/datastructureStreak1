import java.util.LinkedList;
import java.util.Queue;

public class Oct13261 {

    public static void main(String[] args) {
        int[][] matrix = { { 5, 5, 3 }, { 2, 3, 6 }, { 1, 1, 1 } };
        Oct13261 oct = new Oct13261();
        System.out.println("longest--->" + oct.longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] indegree = new int[row][col];
        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < row && nc < col && nr >= 0 && nc >= 0 && matrix[r][c] > matrix[nr][nc])
                        indegree[r][c]++;
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
        int lis = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                int r = temp[0];
                int c = temp[1];
                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr < row && nc < col && nr >= 0 && nc >= 0 && matrix[nr][nc] > matrix[r][c]) {
                        if (--indegree[nr][nc] == 0) {
                            q.offer(new int[] { nr, nc });
                        }
                    }
                }
            }
            lis++;
        }

        return lis;
    }

}
