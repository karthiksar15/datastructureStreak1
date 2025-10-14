import java.util.Deque;
import java.util.LinkedList;

public class Feb01 {

    public static void main(String[] args) {
        Feb01 feb = new Feb01();
        char[][] maze = { { '+', '+', '.', '+' }, { '.', '.', '.', '+' }, { '+', '+',
                '+', '.' } };
        // char[][] maze = { { '.', '+' } };
        // char[][] maze = { { '+', '+', '+' }, { '.', '.', '.' }, { '+', '+', '+' } };
        // int[] entrance = { 1, 0 };
        // int[] entrance = { 0, 0 };
        int[] entrance = { 1, 2 };
        int nearest = feb.nearestExit(maze, entrance);
        System.out.println("Nearest exit is-->" + nearest);

    }

    public int nearestExit(char[][] maze, int[] entrance) {
        Deque<int[]> queue = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        int[] newArr = { entrance[0], entrance[1], 0 };
        queue.add(newArr);
        int rowLen = maze.length;
        int colLen = maze[0].length;
        boolean[][] seen = new boolean[rowLen][colLen];
        seen[entrance[0]][entrance[1]] = true;
        int[] rowPos = { 1, -1, 0, 0 };
        int[] colPos = { 0, 0, 1, -1 };
        while (!queue.isEmpty()) {
            int[] popped = queue.pop();
            int count = popped[2];
            int row = popped[0];
            int col = popped[1];
            if ((row == 0 || col == colLen - 1 || row == rowLen - 1 || col == 0) && count > 0) {
                min = Math.min(min, count);
                continue;
            }
            for (int i = 0; i < rowPos.length; i++) {
                int newRowPos = row + rowPos[i];
                int newColPos = col + colPos[i];
                if (newRowPos >= 0 && newColPos < colLen && newRowPos < rowLen && newColPos >= 0) {
                    if (maze[newRowPos][newColPos] == '.' && (!seen[newRowPos][newColPos])) {
                        queue.add(new int[] { newRowPos, newColPos, count + 1 });
                        seen[newRowPos][newColPos] = true;
                    }
                }
            }

        }
        return min == 0 || min == Integer.MAX_VALUE ? -1 : min;
    }

}

