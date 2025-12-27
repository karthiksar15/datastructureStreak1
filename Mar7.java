import java.util.LinkedList;
import java.util.Queue;

public class Mar5 {

    public static void main(String[] args) {
        Mar5 mar = new Mar5();
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        int[][] result = mar.updateMatrix(mat);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] distance = new int[mat.length][mat[0].length];
        int INF = Integer.MAX_VALUE / 2;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    queue.add(new int[] { i, j });
                } else {
                    distance[i][j] = INF;
                }
            }
        }
        int[] dr = { 1, 0, -1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            for (int i = 0; i < dr.length; i++) {
                int nxtRw = temp[0] + dr[i];
                int nxtCol = temp[1] + dc[i];
                if (nxtRw >= 0 && nxtRw < mat.length && nxtCol >= 0 && nxtCol < mat.length) {
                    if (distance[nxtRw][nxtCol] > distance[temp[0]][temp[1]] + 1) {
                        distance[nxtRw][nxtCol] = distance[temp[0]][temp[0]] + 1;
                        queue.offer(new int[] { nxtRw, nxtCol });
                    }
                }
            }
        }
        return distance;
    }

}
