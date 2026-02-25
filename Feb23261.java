import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Feb2326 {
    public static void main(String[] args) {
        Feb2326 feb = new Feb2326();
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0,
                0 } };
        // int[][] grid = { { 0, 1, 1 }, { 1, 1, 1 }, { 1, 0, 0 } };
        int k = 1;
        System.out.println("shortest path--->" + feb.shortestPath(grid, k));
    }

    public int shortestPath(int[][] grid, int k) {
        int R = grid.length;
        int C = grid[0].length;
        int min = (R - 1) + (C - 1);
        if (grid[0][0] == 1 && k == 0)
            return -1;
        if (k == min)
            return min;
        return aStar(grid, k);
    }

    public int aStar(int[][] grid, int k) {
        int R = grid.length;
        int C = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int hf = heuristic(0, 0, R - 1, C - 1);
        pq.add(new int[] { hf, 0, 0, 0, k - grid[0][0] });
        int[][] best = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                best[i][j] = -1;
            }
        }
        best[0][0] = k - grid[0][0];
        int[] dr = { 0, 1, -1, 0 };
        int[] dc = { 1, 0, 0, -1 };
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int f = temp[0];
            int r = temp[1];
            int c = temp[2];
            int sc = temp[3];
            int rem = temp[4];

            if (r == R - 1 && c == C - 1) {
                return sc;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                    continue;

                int cell = grid[nr][nc];
                int remChk = rem - cell;
                if (remChk < 0)
                    continue;
                if (best[nr][nc] >= remChk)
                    continue;

                best[nr][nc] = remChk;
                int nSc = sc + 1;
                int nh = heuristic(nr, nc, R - 1, C - 1);
                int nf = nSc + nh;
                pq.offer(new int[] { nf, nr, nc, nSc, remChk });
            }
        }
        return -1;
    }

    public int heuristic(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
