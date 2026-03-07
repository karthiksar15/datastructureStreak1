import java.util.PriorityQueue;

public class Mar0526 {

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 0 } };
        int k = 1;
        Mar0526 mar = new Mar0526();
        System.out.println("shortest path---->" + mar.shortestPath(grid, k));
    }

    public int shortestPath(int[][] grid, int k) {
        int R = grid.length;
        int C = grid[0].length;
        int sum = ((R - 1) + (C - 1));
        if (k >= sum)
            return sum;
        return astar(grid, k, R, C);
    }

    public int astar(int[][] grid, int k, int R, int C) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] best = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                best[i][j] = -1;
            }
        }
        best[0][0] = k - grid[0][0];
        int hr = heuristic(0, 0, R - 1, C - 1);
        queue.add(new int[] { hr, 0, 0, 0, k - grid[0][0] });
        int[] dr = { 0, 0, 1, -1 };
        int[] dc = { 1, -1, 0, 0 };
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int or = temp[1];
            int oc = temp[2];
            int od = temp[3];
            int orem = temp[4];
            if (or == R - 1 && oc == C - 1)
                return od;
            for (int i = 0; i < dr.length; i++) {
                int nr = or + dr[i];
                int nc = oc + dc[i];
                if (nr < 0 || nr > R - 1 || nc < 0 || nc > C - 1)
                    continue;
                int nrem = orem - grid[nr][nc];
                int nhr = heuristic(nr, nc, R - 1, C - 1);
                if (nrem < 0)
                    continue;
                if (best[nr][nc] >= nrem)
                    continue;
                // Update best remaining eliminations for this cell to prune worse states
                best[nr][nc] = nrem;
                int nd = od + 1;
                int nfn = od + 1 + nhr;
                queue.add(new int[] { nfn, nr, nc, nd, nrem });
            }

        }
        return -1;
    }

    public int heuristic(int r, int c, int r1, int c1) {
        return Math.abs(r - r1) + Math.abs(c - c1);
    }

}
