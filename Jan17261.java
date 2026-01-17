import java.util.HashSet;
import java.util.Set;

public class Jan17261 {

    private int size;

    public static void main(String[] args) {
        Jan17261 jan = new Jan17261();
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
            int currDiagnol = row - col;
            int currAntiDiagnol = row + col;

            if (cols.contains(col) || diagnols.contains(currDiagnol) || antiDiagnols.contains(currAntiDiagnol)) {
                continue;
            }
            cols.add(col);
            diagnols.add(currDiagnol);
            antiDiagnols.add(currAntiDiagnol);
            solutions += backtrack(row + 1, cols, diagnols, antiDiagnols);

            cols.remove(col);
            diagnols.remove(currDiagnol);
            antiDiagnols.remove(currAntiDiagnol);
        }
        return solutions;
    }
}
