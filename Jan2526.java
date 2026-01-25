import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Jan2526 {

    public static void main(String[] args) {
        Jan2526 jan = new Jan2526();
        // int[][] bombs = { { 1, 2, 1 }, { 2, 3, 1 }, { 3, 4, 1 }, { 4, 5, 1 }, { 5, 6,
        // 6 } };
        // int[][] bombs = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6,
        // 4 } };
        // int[][] bombs = { { 1, 1, 5 }, { 10, 10, 5 } };
        int[][] bombs = { { 2, 1, 3 }, { 6, 1, 4 } };
        // int[][] bombs = { { 4, 4, 3 }, { 4, 4, 3 } };
        System.out.println("maximum--->" + jan.maximumDetonation(bombs));
    }

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        List<Integer>[] map = new ArrayList[bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = bombs[i][0];
                int y1 = bombs[i][1];
                int x2 = bombs[j][0];
                int y2 = bombs[j][1];
                int r1 = bombs[i][2];
                if (i == j)
                    continue;
                if (r1 * r1 >= ((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1))) {
                    map[i].add(j);
                }
            }
        }
        int max = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            Arrays.fill(visited, false);
            Deque<Integer> qDeque = new LinkedList<>();
            qDeque.add(i);
            visited[i] = true;
            while (!qDeque.isEmpty()) {
                int temp = qDeque.poll();
                count++;
                for (int j : map[temp]) {
                    if (!visited[j]) {
                        visited[j] = true;
                        qDeque.add(j);
                    }
                }

            }
            max = Math.max(count, max);
        }
        return max;
    }

}
