import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Mar1 {
    public static void main(String[] args) {
        Mar1 ma = new Mar1();
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 0 } };
        int k = 1;
        System.out.println("grid----" + ma.shortestPath(grid, k));
    }

    public int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] target = { rows - 1, cols - 1 };

        PriorityQueue<StepState> queue = new PriorityQueue<>();
        Set<StepState> seen = new HashSet<>();

        StepState start = new StepState(0, 0, 0, k, target);
        queue.offer(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            StepState curr = queue.poll();
            int remMinDistance = curr.estimation - curr.steps;
            if (remMinDistance <= curr.k) {
                return curr.estimation;
            }
            int[] nextSteps = { curr.row, curr.col + 1, curr.row + 1, curr.col, curr.row, curr.col - 1, curr.row - 1,
                    curr.col };
            for (int i = 0; i < nextSteps.length; i += 2) {
                int nextRow = nextSteps[i];
                int nextCol = nextSteps[i + 1];
                // out of the boundary of grid
                if (0 > nextRow || nextRow == rows || 0 > nextCol || nextCol == cols) {
                    continue;
                }
                int nextElimination = curr.k - grid[nextRow][nextCol];
                StepState stepState = new StepState(curr.steps + 1, nextRow, nextCol, nextElimination, target);

                if (nextElimination >= 0 && (!seen.contains(stepState))) {
                    seen.add(stepState);
                    queue.offer(stepState);
                }
            }
        }
        return -1;
    }
}

class StepState implements Comparable {
    /**
     * state info for each step:
     * <estimation, steps, row, col, remaining_eliminations>
     */
    public int estimation, steps, row, col, k;
    private int[] target;

    public StepState(int steps, int row, int col, int k, int[] target) {
        this.steps = steps;
        this.row = row;
        this.col = col;
        this.k = k;

        this.target = target;
        int manhattanDistance = target[0] - row + target[1] - col;
        // h(n) = manhattan distance, g(n) = 0
        // estimation = h(n) + g(n)
        this.estimation = manhattanDistance + steps;
    }

    @Override
    public int hashCode() {
        return (this.row + 1) * (this.col + 1) * this.k;
    }

    @Override
    public int compareTo(Object o) {
        // order the elements solely based on the 'estimation' value
        StepState other = (StepState) o;
        return this.estimation - other.estimation;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof StepState)) {
            return false;
        }
        StepState newState = (StepState) o;
        return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
    }

    @Override
    public String toString() {
        return String.format("(%d %d %d %d %d)",
                this.estimation, this.steps, this.row, this.col, this.k);
    }
}
