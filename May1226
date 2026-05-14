public class May1226 {

    public static void main(String[] args) {
        May1226 may = new May1226();
        int[][] matrix = { { 1, 2, 4, 8 }, { 10, 11, 12, 13 }, { 14, 20, 30, 40 } };
        int target = 10;
        System.out.println("searchMatrix--->" + may.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        int l = 0, r = ROWS * COLS - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            int row = m / COLS, col = m % COLS;
            if (target > matrix[row][col]) {
                l = m + 1;
            } else if (target < matrix[row][col]) {
                r = m - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
