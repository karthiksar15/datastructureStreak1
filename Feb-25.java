import java.util.HashSet;
import java.util.Set;

public class Feb25 {
    Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        Feb25 feb = new Feb25();
        int[][] grid = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
        System.out.println("max area of island--->" + feb.maxAreaOfIsland(grid));
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                String cell = i + "#" + j;
                if (!visited.contains(cell) && grid[i][j] == 1) {
                    visited.add(cell);
                    max = Math.max(max, validateArea(i, j, grid, 1));
                }
            }
        }
        return max;
    }

    public int validateArea(int i, int j, int[][] grid, int count) {
        if (grid[i][j] == 0)
            return 0;
        int[][] cells = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        for (int m = 0; m < cells.length; m++) {
            int nextRow = i + cells[m][0];
            int nextColumn = j + cells[m][1];
            String newCell = nextRow + "#" + nextColumn;
            if (validate(nextRow, nextColumn, grid, newCell)) {
                visited.add(newCell);
                count = validateArea(nextRow, nextColumn, grid, count) + 1;
            }
        }
        return count;
    }

    public boolean validate(int row, int col, int[][] grid, String cell) {
        return (row >= 0 && row < grid.length && col < grid[0].length && col >= 0 && (!visited.contains(cell))
                && grid[row][col] == 1);
    }

}
