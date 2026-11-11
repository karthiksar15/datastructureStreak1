public class Nov11267 {

    public static void main(String[] args) {
        Nov11267 nov = new Nov11267();
        System.out.println("totalNQueens--->" + nov.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] posDiag = new boolean[2 * n];
        boolean[] negDiag = new boolean[2 * n];
        int[] res = new int[1];
        backtrack(0, n, col, posDiag, negDiag, res);
        return res[0];
    }

    public void backtrack(int r, int n, boolean[] col, boolean[] posDiag, boolean[] negDiag, int[] res) {
        if (r == n) {
            res[0]++;
            return;
        }
        for (int c = 0; c < n; c++) {
            if (col[c] || posDiag[r + c] || negDiag[r - c + n])
                continue;
            col[c] = true;
            posDiag[r + c] = true;
            negDiag[r - c + n] = true;
            backtrack(r + 1, n, col, posDiag, negDiag, res);
            col[c] = false;
            posDiag[r + c] = false;
            negDiag[r - c + n] = false;
        }
    }

}
