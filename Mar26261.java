public class Mar26261 {

    private int[][] precompute;

    public static void main(String[] args) {
        int[][] mat = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } };
        Mar26261 mar = new Mar26261(mat);
        int output = mar.sumRegion(2, 1, 4, 3);
        // int output = mar.sumRegion(1, 1, 2, 2);
        System.out.println("total sum--->" + output);
    }

    public Mar26261(int[][] mat) {
        precompute = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                precompute[i][j] = mat[i][j];
                if (i > 0) {
                    precompute[i][j] += precompute[i - 1][j];
                }
                if (j > 0) {
                    precompute[i][j] += precompute[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    precompute[i][j] = precompute[i][j] - precompute[i - 1][j - 1];
                }

            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = precompute[row2][col2];
        if (col1 > 0)
            result -= precompute[row2][col1 - 1];
        if (row1 > 0)
            result -= precompute[row1 - 1][col2];
        if (row1 > 0 && col1 > 0)
            result += precompute[row1 - 1][col1 - 1];
        return result;
    }

}
