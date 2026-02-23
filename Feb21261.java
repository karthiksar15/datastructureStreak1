import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Feb2126 {

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        Feb2126 feb = new Feb2126();
        Arrays.stream(feb.updateMatrix(mat)).forEach(v -> System.out.print(Arrays.toString(v)));
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];
        boolean[][] seen = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0 && (!seen[i][j])) {
                    bfs(i, j, dist, seen, mat);
                }
            }
        }
        return dist;
    }

    public void bfs(int i, int j, int[][] dist, boolean[][] seen, int[][] mat) {
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[] { i, j, 1 });
        seen[i][j] = true;
        int[] dr = { 0, -1, 0, 1 };
        int[] dc = { 1, 0, -1, 0 };
        while (!queue.isEmpty()) {
            int[] temp = queue.pollLast();
            for (int k = 0; k < dr.length; k++) {
                int newRow = temp[0] + dr[k];
                int newCol = temp[1] + dc[k];
                int distance = temp[2];
                if (newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length
                        && mat[newRow][newCol] == 1 && (!seen[newRow][newCol] || distance < dist[newRow][newCol])) {
                    queue.add(new int[] { newRow, newCol, distance + 1 });
                    seen[newRow][newCol] = true;
                    dist[newRow][newCol] = distance;
                }
            }

        }
    }

}
