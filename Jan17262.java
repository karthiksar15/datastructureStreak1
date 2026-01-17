import java.util.HashSet;
import java.util.Set;

public class Jan17262 {

    private int size;

    public static void main(String[] args) {
        Jan17262 jan = new Jan17262();
        System.out.println("totalQueens--->" + jan.totalNQueens(4));

    }

    public int totalNQueens(int n) {
        this.size = n;
        return backtrack(0, new HashSet(), new HashSet(), new HashSet());
    }

    public int backtrack(int row, Set<Integer> cols, Set<Integer> diagnols, Set<Integer> antiDiagnols) {
        if (row == size)
            return 1;

        int solutions = 0;
        for (int col = 0; col < size; col++) {
            int diagnol = row - col;
            int antiDiagnol = row + col;
            if (cols.contains(col) || (diagnols.contains(diagnol)) || (antiDiagnols.contains(antiDiagnol))) {
                continue;
            }
            cols.add(col);
            diagnols.add(diagnol);
            antiDiagnols.add(antiDiagnol);
            solutions += backtrack(row + 1, cols, diagnols, antiDiagnols);
            cols.remove(col);
            diagnols.remove(diagnol);
            antiDiagnols.remove(antiDiagnol);
        }
        return solutions;
    }
}
