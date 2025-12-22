import java.util.LinkedList;
import java.util.Queue;

public class Feb28 {

    public static void main(String[] args) {
        Feb28 feb = new Feb28();
        // int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] mat = { { 1, 0, 1, 1, 0, 0, 1, 0, 0, 1 }, { 0, 1, 1, 0, 1, 0, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 1, 0, 0, 1, 0, 0 }, { 1, 0, 1, 0, 1, 1, 1, 1, 1, 1 }, { 0, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
                { 0, 0, 1, 0, 1, 1, 1, 0, 1, 0 }, { 0, 1, 0, 1, 0, 1, 0, 0, 1, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 0, 1, 0 }, { 1, 1, 1, 1, 0, 1, 0, 0, 1, 1 } };
        int[][] result = feb.updateMatrix(mat);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1)
                    result[i][j] = validate(i, j, mat);
                else
                    result[i][j] = 0;
            }
        }
        return result;
    }

    public int validate(int row, int column, int[][] mat) {
        int[] rows = { 0, -1, 1, 0 };
        int[] cols = { 1, 0, 0, -1 };
        int count = 1;
        Queue<Integer[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        queue.add(new Integer[] { row, column });
        visited[row][column] = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            Integer[] temp = queue.poll();
            row = temp[0];
            column = temp[1];
            // for (int i = 0; i < len; i++) {
            for (int j = 0; j < rows.length; j++) {
                int nextRow = row + rows[j];
                int nextCol = column + cols[j];
                if (nextRow >= 0 && nextRow < mat.length && nextCol >= 0 && nextCol < mat[0].length
                        && mat[nextRow][nextCol] == 0) {
                    queue.clear();
                    return count;
                } else if (nextRow >= 0 && nextRow < mat.length && nextCol >= 0 && nextCol < mat[0].length
                        && mat[nextRow][nextCol] == 1 && (!visited[nextRow][nextCol])) {
                    queue.add(new Integer[] { nextRow, nextCol });
                    visited[nextRow][nextCol] = true;
                }
            }
            // }
            count++;
        }
        return -1;
    }

}

