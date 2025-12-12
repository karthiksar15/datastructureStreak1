import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Feb24 {

    public static void main(String[] args) {
        Feb24 feb = new Feb24();
        int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
        System.out.println("max area of island--->" + feb.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        Set<String> visited = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                String newCell = i + "#" + j;
                if (grid[i][j] == 1 && (!visited.contains(newCell))) {
                    visited.add(newCell);
                    maxArea = Math.max(maxArea, checkDeep(i, j, grid, visited));
                }
            }
        }
        return maxArea;
    }

    public int checkDeep(int row, int col, int[][] grid, Set<String> visited) {
        int count = 0;
        Stack<Pairss> pairs = new Stack<>();
        pairs.push(new Pairss(row, col));
        while (!pairs.isEmpty()) {
            Pairss temp = pairs.pop();
            count++;
            validateArea(temp.row, temp.cols, grid, pairs, visited);
        }
        return count;
    }

    public void validateArea(int row, int col, int[][] grid, Stack<Pairss> pairs, Set<String> visited) {
        int[][] check = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        for (int i = 0; i < check.length; i++) {
            int nextRow = row + check[i][0];
            int nextColumn = col + check[i][1];
            String nextCell = nextRow + "#" + nextColumn;
            if (nextRow >= 0 && nextRow < grid.length && nextColumn >= 0 && nextColumn < grid[0].length
                    && grid[nextRow][nextColumn] == 1 && (!visited.contains(nextCell))) {
                pairs.push(new Pairss(nextRow, nextColumn));
                visited.add(nextCell);
            }

        }
    }

    class Pairss {
        public int row;
        public int cols;

        public Pairss(int row, int cols) {
            this.row = row;
            this.cols = cols;
        }
    }

}

