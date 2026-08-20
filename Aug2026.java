import java.util.LinkedList;
import java.util.Queue;

public class Aug2026 {

    public static void main(String[] args) {
        Aug2026 aug = new Aug2026();
        int[][] mat = { { 5, 5, 3 }, { 2, 3, 6 }, { 1, 1, 1 } };
        System.out.println("longest--->" + aug.longestIncreasingPath(mat));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int ROW = matrix.length, COL = matrix[0].length;
        int[][] indegree = new int[ROW][COL];
        int[][] directions = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr > 0 && nr < ROW && nc > 0 && nc < COL && matrix[nr][nc] < matrix[r][c]) {
                        indegree[r][c]++;
                    }
                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < ROW; r++) {
            for (int c = 0; c < COL; c++) {
                if (indegree[r][c] == 0) {
                    q.offer(new int[] { r, c });
                }
            }
        }
        int LIS = 0;
        while (!q.isEmpty()) {
            int size = q.size();

        }
    }

}
