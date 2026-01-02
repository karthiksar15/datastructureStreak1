import java.util.LinkedList;
import java.util.Queue;

public class Jan0226 {

    public static void main(String[] args) {
        int[][] board = { { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1 },
                { -1, 35, -1, -1, 13, -1 }, { -1, -1, -1, -1, -1, -1 }, { -1, 15, -1, -1, -1, -1 } };
        Jan0226 jan = new Jan0226();
        System.out.println("least roll--->" + jan.snakesAndLadders(board));
    }

    public int snakesAndLadders(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();
        int count = -1;
        int rowLen = board.length;
        int colLen = board[0].length;

        if (diceCheck(board))
            return 1;
        queue.add(new int[] { rowLen - 1, 0, 0 });
        for (int i = rowLen - 1; i >= 0; i--) {
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int row = temp[0];
                int col = temp[1];
                int newCount = temp[2];
                if (row == 0 && col == 0)
                    return newCount;
                for (int j = 1; j <= 6; j++) {
                    int colCell = destination(col + j, board);
                    if (board[row][colCell] != -1) {
                        int[] cell = fetchCell(board[row][colCell], board);
                        queue.add(new int[] { cell[0], cell[1], newCount + 1 });
                    } else if (board[row][colCell] == -1) {
                        queue.add(new int[] { row, colCell + j, newCount + 1 });
                    }
                }

            }
        }
        return count;
    }

    public boolean diceCheck(int[][] board) {
        int dice = 6;
        if (dice > board.length)
            return true;
        return false;
    }

    public int[] fetchCell(int num, int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == num)
                    return new int[] { i, j };
            }
        }
        return new int[] {};
    }

    public int destination(int cur, int[][] board) {
        return Math.min(cur, board[0].length - cur);
    }

}
