import java.util.ArrayList;
import java.util.List;

public class Nov0926 {

    public List<List<String>> solveNQueens(int n) {
        boolean[] col = new boolean[n];
        boolean[] posDiag = new boolean[2 * n];
        boolean[] negDiag = new boolean[2 * n];
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0, n, res, col, posDiag, negDiag, board);
        return res;
    }

    public void backtrack(int r, int n, List<List<String>> res, boolean[] col, boolean[] posDiag, boolean[] negDiag,
            char[][] board) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (char[] row : board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }
        for (int c = 0; c < n; c++) {
            if (col[c] || posDiag[r + c] || negDiag[r - c + n]) {
                continue;
            }
            col[c] = true;
            posDiag[r + c] = true;
            negDiag[r - c + n] = true;
            board[r][c] = 'Q';
            backtrack(r + 1, n, res, col, posDiag, negDiag, board);
            col[c] = false;
            posDiag[r + c] = false;
            negDiag[r - c + n] = false;
            board[r][c] = '.';
        }
    }

    public static void main(String[] args) {
        Nov0926 nov = new Nov0926();
        System.out.println("solveQueens-->" + nov.solveNQueens(4));
    }

}
