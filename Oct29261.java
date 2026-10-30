public class Oct29261 {

    public static void main(String[] args) {
        Oct29261 oct = new Oct29261();
        char[][] board = { { 'A', 'B', 'C', 'D' }, { 'S', 'A', 'A', 'T' }, { 'A', 'C', 'A', 'E' } };
        System.out.println("exist--->" + oct.exist(board, "CAT"));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, m, n)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int r, int c, int i, int m, int n) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != word.charAt(i) || board[r][c] == '#') {
            return false;
        }
        board[r][c] = '#';
        boolean res = dfs(board, word, r + 1, c, i + 1, m, n) ||
                dfs(board, word, r - 1, c, i + 1, m, n) ||
                dfs(board, word, r, c + 1, i + 1, m, n) ||
                dfs(board, word, r, c - 1, i + 1, m, n);
        board[r][c] = word.charAt(i);
        return res;
    }

}
