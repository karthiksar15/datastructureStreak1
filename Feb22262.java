import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Feb2226 {

    public static void main(String[] args) {
        Feb2226 feb = new Feb2226();
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0,
                0 } };
        // int[][] grid = { { 0, 1, 1 }, { 1, 1, 1 }, { 1, 0, 0 } };
        int k = 1;
        System.out.println("shortest path--->" + feb.shortestPath(grid, k));
    }

    public int shortestPath(int[][] grid, int k) {
        int R = grid.length, C = grid[0].length;
        // Trivial start invalid
        if (grid[0][0] == 1 && k == 0)
            return -1;
        // If k is large enough to bulldoze straight Manhattan path
        int minSteps = (R - 1) + (C - 1);
        if (k >= minSteps)
            return minSteps; // optimal straight path

        return aStar(grid, k);
    }

    // A* with Manhattan distance heuristic
    private int aStar(int[][] grid, int k) {
        int R = grid.length, C = grid[0].length;

        // Priority on f = g + h; we store {f, r, c, g, remainingK}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int h0 = manhattan(0, 0, R - 1, C - 1);
        pq.offer(new int[] { h0, 0, 0, 0, k - grid[0][0] }); // if start is 1, we consume one k

        // best[r][c] = max remainingK we've seen reaching (r,c)
        int[][] bestRem = new int[R][C];
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++)
                bestRem[r][c] = -1;
        }
        bestRem[0][0] = k - grid[0][0];

        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int f = cur[0];
            int r = cur[1];
            int c = cur[2];
            int g = cur[3];
            int rem = cur[4];

            // Goal
            if (r == R - 1 && c == C - 1)
                return g;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                    continue;

                int cell = grid[nr][nc];
                int nrem = rem - cell; // consume 1 if obstacle
                if (nrem < 0)
                    continue; // cannot pass

                // If we have been here with >= remaining eliminations, skip
                if (bestRem[nr][nc] >= nrem)
                    continue;

                bestRem[nr][nc] = nrem;
                int ng = g + 1;
                int nh = manhattan(nr, nc, R - 1, C - 1);
                int nf = ng + nh;
                pq.offer(new int[] { nf, nr, nc, ng, nrem });
            }
        }

        return -1;
    }

    private int manhattan(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }

}
