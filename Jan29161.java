import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Jan29161 {

    public static void main(String[] args) {
        Jan29161 jan = new Jan29161();
        // int[][] bombs = { { 1, 2, 1 }, { 2, 3, 1 }, { 3, 4, 1 }, { 4, 5, 1 }, { 5, 6,
        // 6 } };
        // int[][] bombs = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6,
        // 4 } };
        int[][] bombs = { { 1, 1, 5 }, { 10, 10, 5 } };
        // int[][] bombs = { { 2, 1, 3 }, { 6, 1, 4 } };
        // int[][] bombs = { { 4, 4, 3 }, { 4, 4, 3 } };
        System.out.println("maximum--->" + jan.maximumDetonation(bombs));
    }

    public int maximumDetonation(int[][] bombs) {
        List<Integer>[] map = new ArrayList[bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (i == j)
                    continue;
                int xi = bombs[i][0] - bombs[j][0];
                int yi = bombs[i][1] - bombs[j][1];
                long ri = bombs[i][2] * bombs[i][2];
                if (ri >= ((xi * xi) + (yi * yi))) {
                    map[i].add(j);
                }
            }
        }

        int count = 1;
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bombs.length; i++) {
            queue.add(i);
            int result = 1;
            boolean[] visited = new boolean[bombs.length];
            visited[0] = true;
            while (!queue.isEmpty()) {
                Integer temp = queue.poll();
                for (Integer j : map[temp]) {
                    if (!visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                        result++;
                    }
                }

            }
            count = Math.max(count, result);
        }

        return count;
    }

}
