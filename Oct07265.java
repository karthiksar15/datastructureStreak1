import java.util.Queue;

class Oct07265 {
    public static void main(String[] args) {
        Oct07265 oct = new Oct07265();
        int[][] matrix = { { 5, 5, 3 }, { 2, 3, 6 }, { 1, 1, 1 } };
        System.out.println("longest-->" + oct.longestIncreasingPath(matrix));
    }

    public int longestIncreasingPath(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] indgree = new int[R + 1][C + 1];
        int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && matrix[r][c] > matrix[nr][nc]) {
                        indgree[r][c]++;
                    }
                }

            }
        }
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (indgree[r][c] == 0) {
                    q.offer(new int[] { r, c });
                }
            }
        }
        int LIS = 0;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                int[] temp = q.poll();
                int r = temp[0], c = temp[1];
                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && matrix[nr][nc] > matrix[r][c]) {
                        if (--indgree[nr][nc] == 0) {
                            q.add(new int[] { nr, nc });
                        }
                    }
                }
            }
            LIS++;
        }
        return LIS;
    }
}