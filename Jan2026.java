public class Jan2026 {

    int[] rows = new int[] { -1, 1, 0, 0 };
    int[] cols = new int[] { 0, 0, 1, -1 };
    String target = "";
    boolean[][] seen;

    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        // String word = "ABCCED";
        // String word = "SEE";
        String word = "ABCB";
        Jan17263 jan = new Jan17263();
        System.out.println("word exist--->" + jan.exist(board, word));
    }

    public boolean exist(char[][] board, String word) {
        this.target = word;
        seen = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    seen[i][j] = true;
                    if (backtrack(i, j, board, 1)) {
                        return true;
                    }
                    seen[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean backtrack(int row, int col, char[][] board, int index) {
        if (index == target.length())
            return true;

        for (int i = 0; i < rows.length; i++) {
            int nextRow = row + rows[i];
            int nextCol = col + cols[i];
            if (isValid(nextRow, nextCol, board) && !seen[nextRow][nextCol]) {
                if ((board[nextRow][nextCol] == this.target.charAt(index))) {
                    seen[nextRow][nextCol] = true;
                    boolean check = backtrack(nextRow, nextCol, board, index + 1);
                    if (check) {
                        return true;
                    }
                    seen[nextRow][nextCol] = false;
                }
            }
        }
        return false;
    }

    public boolean isValid(int row, int col, char[][] board) {
        return (row >= 0 && row < board.length && col >= 0 && col < board[0].length);
    }

}
