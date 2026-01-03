import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Jan0326 {

    public static void main(String[] args) {
        int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
        Jan0326 jan = new Jan0326();
        System.out.println("shortest---" + jan.snakesAndLadders(board));
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[(n * n) + 1];
        int[] columns = new int[n];
        for (int i = 0; i < n; i++) {
            columns[i] = i;
        }
        int label = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int column : columns) {
                cells[label] = new Pair(i, column);
            }
            Collections.reverse(Arrays.asList(columns));
        }
        int[] dist = new int[(n * n) + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next = curr + 1; next <= Math.min(n * n, curr + 6); next++) {
                int row = cells[next].row1, column = cells[next].column1;
                int destination = board[row][column] != -1 ? board[row][column] : next;
                if (dist[destination] == -1) {
                    dist[destination] = dist[curr] + 1;
                    queue.add(destination);
                }
            }
        }
        return dist[n * n];
    }

    record Pair<K, V>(K row1, V column1) {
    };

}
