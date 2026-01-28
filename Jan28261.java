import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Jan28261 {

    public static void main(String[] args) {
        Jan28261 jan = new Jan28261();
        // int[][] bombs = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6,
        // 4 } };
        int[][] bombs = { { 2, 1, 3 }, { 6, 1, 4 } };
        System.out.println("detonate--->" + jan.maximumDetonation(bombs));
    }

    public int maximumDetonation(int[][] bombs) {
        int count = 1;
        List<Integer>[] list = new ArrayList[bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (i == j)
                    continue;
                long xi = bombs[i][0] - bombs[j][0];
                long yi = bombs[i][1] - bombs[j][1];
                long ri = bombs[i][2];
                if (ri * ri >= (xi * xi) + (yi * yi)) {
                    list[i].add(j);
                }
            }
        }
        for (int i = 0; i < bombs.length; i++) {
            int result = 1;
            boolean[] visited = new boolean[bombs.length];
            Deque<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            while (!queue.isEmpty()) {
                Integer temp = queue.poll();
                List<Integer> list1 = list[temp];
                for (int num : list1) {
                    if (!visited[num]) {
                        visited[num] = true;
                        queue.add(num);
                        result++;
                    }
                }

            }
            count = Math.max(count, result);

        }
        return count;
    }

}
