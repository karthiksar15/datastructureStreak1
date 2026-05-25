public class May25264 {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 4, 8 }, { 10, 11, 12, 13 }, { 14, 20, 30, 40 } };
        int target = 12;
        May25264 may = new May25264();
        System.out.println("searchMatrix--->" + may.searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int l = 0;
        int r = m * n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int row = mid / n, col = mid % n;
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return false;
    }

}
