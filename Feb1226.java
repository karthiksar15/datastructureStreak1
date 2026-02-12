import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Feb1026 {

    public static void main(String[] args) {
        Feb1026 feb = new Feb1026();
        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

        System.out
                .println(Arrays.stream(feb.updateMatrix(mat)).map(Arrays::toString).collect(Collectors.joining("\n")));
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    result[i][j] = bfs(i, j, mat);
                }
            }
        }
        return result;
    }

    public int bfs(int i, int j, int[][] mat) {
        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };
        int result = Integer.MAX_VALUE;
        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        queue.add(new int[] { i, j });
        int count = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int m = 0; m < size; m++) {
                int[] path = queue.poll();
                int row = path[0];
                int col = path[1];
                for (int n = 0; n < dr.length; n++) {
                    int newRow = row + dr[n];
                    int newCol = col + dc[n];
                    if (isValid(newRow, newCol, mat, visited) && mat[newRow][newCol] == 0) {
                        result = Math.min(result, count);
                        visited[newRow][newCol] = true;
                    } else if (isValid(newRow, newCol, mat, visited) && mat[newRow][newCol] == 1) {
                        queue.add(new int[] { newRow, newCol });
                        visited[newRow][newCol] = true;
                    }
                }
            }
            count++;
        }
        return result;

    }

    public boolean isValid(int newRow, int newCol, int[][] mat, boolean[][] visited) {
        return newRow >= 0 && newRow < mat.length && newCol >= 0 && newCol < mat[0].length
                && (!visited[newRow][newCol]);
    }

}
