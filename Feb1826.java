import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Feb1626 {

    public static void main(String[] args) {
        Feb1626 feb = new Feb1626();
        int n = 3;
        int[][] redEdges = { { 0, 1 } }, blueEdges = { { 2, 1 } };
        // 5 r-->[[0,1],[1,2],[2,3],[3,4]] b->[[1,2],[2,3],[3,1]]
        Arrays.stream(feb.shortestAlternatingPaths(n, redEdges, blueEdges)).forEach(System.out::println);
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int[] e : redEdges) {
            redMap.computeIfAbsent(e[0], v -> new ArrayList<>()).add(e[1]);
        }
        for (int[] e : blueEdges) {
            blueMap.computeIfAbsent(e[0], v -> new ArrayList<>()).add(e[1]);
        }
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE / 2);
        Deque<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[n][n];
        queue.add(new int[] { 0, 0, 0 });
        queue.add(new int[] { 0, 1, 0 });
        seen[0][0] = true;
        seen[0][1] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int node = temp[0];
            int color = temp[1];
            int dist = temp[2];
            result[node] = Math.min(dist, result[node]);
            if (color == 0) {
                for (int neg : blueMap.getOrDefault(node, new ArrayList<>())) {
                    if (!seen[color][neg]) {
                        queue.add(new int[] { neg, 1, dist + 1 });
                        seen[color][neg] = true;
                    }
                }
            } else {
                for (int neg : redMap.getOrDefault(node, new ArrayList<>())) {
                    if (!seen[color][neg]) {
                        queue.add(new int[] { neg, 0, dist + 1 });
                        seen[color][neg] = true;
                    }
                }
            }
        }
        int[] updated = Arrays.stream(result).map(v -> v == Integer.MAX_VALUE / 2 ? -1 : v).toArray();
        return updated;
    }

}
