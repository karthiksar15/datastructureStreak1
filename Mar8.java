import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Mar6 {

    public static void main(String[] args) {

        Mar1 ma = new Mar1();

        int[][] grid1 = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 0 } };

        int k1 = 1;

        System.out.println("grid1 -> " + ma.shortestPath(grid1, k1)); // expected 6

        int[][] grid2 = { { 0, 1, 1 }, { 1, 1, 1 }, { 1, 0, 0 } };

        int k2 = 1;

        System.out.println("grid2 -> " + ma.shortestPath(grid2, k2)); // example of unreachable or longer path

        int[][] grid3 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

        int k3 = 10;

        System.out.println("grid3 -> " + ma.shortestPath(grid3, k3)); // should be rows+cols-2 = 4

    }

    /**
     * 
     * Shortest Path in a Grid with Obstacles Elimination (LeetCode 1293)
     * 
     * Optimized BFS because each move cost is 1. We keep, for each cell, the
     * maximum
     * 
     * remaining eliminations we have seen so far (bestK[r][c]). We only push a
     * state if
     * 
     * it reaches the cell with a strictly greater remaining elimination count than
     * previously recorded.
     * 
     * Early exits:
     * 
     * - If k >= rows + cols - 2, we can go straight along a Manhattan path, answer
     * is rows + cols - 2.
     * 
     * - Return as soon as we reach target.
     * 
     */

    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length, cols = grid[0].length;
        int minSteps = rows + cols - 2;
        if (k >= minSteps)
            return minSteps;

        int[][] bestK = new int[rows][cols];
        for (int[] row : bestK)
            java.util.Arrays.fill(row, -1);

        PriorityQueue<State> pq = new PriorityQueue<>();
        State start = new State(0, 0, 0, k, rows - 1, cols - 1);
        pq.offer(start);
        bestK[0][0] = k;

        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            if (cur.r == rows - 1 && cur.c == cols - 1)
                return cur.steps;

            // If at this point, our k is worse than recorded, skip
            if (cur.k < bestK[cur.r][cur.c])
                continue;

            int remMin = manhattan(cur.r, cur.c, rows - 1, cols - 1);
            // Early exit: if we can cover remMin entirely via eliminations
            if (remMin <= cur.k)
                return cur.steps + remMin;

            for (int[] d : dirs) {
                int nr = cur.r + d[0], nc = cur.c + d[1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols)
                    continue;

                int nk = cur.k - grid[nr][nc];
                if (nk < 0)
                    continue;

                if (nk > bestK[nr][nc]) {
                    bestK[nr][nc] = nk;
                    pq.offer(new State(nr, nc, cur.steps + 1, nk, rows - 1, cols - 1));
                }
            }
        }
        return -1;

    }

    private static int manhattan(int r, int c, int tr, int tc) {
        return Math.abs(tr - r) + Math.abs(tc - c);
    }

    private static final class State implements Comparable<State> {
        final int r, c, steps, k, tr, tc;
        final int f; // f = g + h

        State(int r, int c, int steps, int k, int tr, int tc) {
            this.r = r;
            this.c = c;
            this.steps = steps;
            this.k = k;
            this.tr = tr;
            this.tc = tc;
            this.f = steps + manhattan(r, c, tr, tc);
        }

        @Override
        public int compareTo(State o) {
            if (this.f != o.f)
                return this.f - o.f;
            return this.steps - o.steps; // tie-break on fewer steps
        }
    }
}

/*
 * 
 * Optional: If you want to keep an A* version, here is a corrected and improved
 * variant.
 * 
 * Key fixes vs original:
 * 
 * Use Math.abs in Manhattan heuristic.
 * 
 * Maintain bestK[r][c] dominance pruning.
 * 
 * Comparable with tie-break on steps.
 * 
 * Avoid weak hash/equals based seen set; bestK suffices for pruning here.
 * 
 * class AStarMar1 {
 * 
 * public int shortestPathAStar(int[][] grid, int k) {
 * 
 * int rows = grid.length, cols = grid[0].length;
 * 
 * int minSteps = rows + cols - 2;
 * 
 * if (k >= minSteps) return minSteps;
 * 
 * int[][] bestK = new int[rows][cols];
 * 
 * for (int[] row : bestK) java.util.Arrays.fill(row, -1);
 * 
 * PriorityQueue pq = new PriorityQueue<>();
 * 
 * State start = new State(0, 0, 0, k, rows - 1, cols - 1);
 * 
 * pq.offer(start);
 * 
 * bestK[0][0] = k;
 * 
 * int[][] dirs = { {1,0},{-1,0},{0,1},{0,-1} };
 * 
 * while (!pq.isEmpty()) {
 * 
 * State cur = pq.poll();
 * 
 * if (cur.r == rows - 1 && cur.c == cols - 1) return cur.steps;
 * 
 * // If at this point, our k is worse than recorded, skip
 * 
 * if (cur.k = rows || nc = cols) continue;
 * 
 * int nk = cur.k - grid[nr][nc];
 * 
 * if (nk bestK[nr][nc]) {
 * 
 * bestK[nr][nc] = nk;
 * 
 * pq.offer(new State(nr, nc, cur.steps + 1, nk, rows - 1, cols - 1));
 * 
 * }
 * 
 * }
 * 
 * }
 * 
 * return -1;
 * 
 * }
 * 
 * private static int manhattan(int r, int c, int tr, int tc) {
 * 
 * return Math.abs(tr - r) + Math.abs(tc - c);
 * 
 * }
 * 
 * private static final class State implements Comparable {
 * 
 * final int r, c, steps, k, tr, tc;
 * 
 * final int f; // f = g + h
 * 
 * State(int r, int c, int steps, int k, int tr, int tc) {
 * 
 * this.r = r; this.c = c; this.steps = steps; this.k = k; this.tr = tr; this.tc
 * = tc;
 * 
 * this.f = steps + manhattan(r, c, tr, tc);
 * 
 * }
 * 
 * @Override public int compareTo(State o) {
 * 
 * if (this.f != o.f) return this.f - o.f;
 * 
 * return this.steps - o.steps; // tie-break on fewer steps
 * 
 * }
 * 
 * }
 * 
 * }
 * 
 */
