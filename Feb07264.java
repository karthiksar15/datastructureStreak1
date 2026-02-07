import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Feb07264 {

    public static void main(String[] args) {
        Feb07264 feb = new Feb07264();
        // int[][] bombs = { { 2, 1, 3 }, { 6, 1, 4 } };
        int[][] bombs = { { 1, 2, 3 }, { 2, 3, 1 }, { 3, 4, 2 }, { 4, 5, 3 }, { 5, 6, 4 } };
        System.out.println("maximum detonation--->" + feb.maximumDetonation(bombs));
    }

    public int maximumDetonation(int[][] bombs) {
        int result = 1;
        List<Integer>[] map = new ArrayList[bombs.length];
        for (int i = 0; i < bombs.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < bombs.length; i++) {
            for (int j = 0; j < bombs.length; j++) {
                if (i == j)
                    continue;
                double xi = bombs[i][0] - bombs[j][0];
                double yi = bombs[i][1] - bombs[j][1];
                double ri = bombs[i][2];
                if ((ri * ri) >= ((xi * xi) + (yi * yi))) {
                    map[i].add(j);
                }
            }
        }

        for (int i = 0; i < map.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            Set<Integer> visited = new HashSet<>();
            int res = 0;
            while (!queue.isEmpty()) {
                int temp = queue.poll();
                if (map[temp] != null) {
                    for (int j : map[temp]) {
                        if (visited.add(j)) {
                            queue.add(j);
                        }
                    }
                }
                res++;
            }

            result = Math.max(result, res);
        }

        return result;
    }

}
