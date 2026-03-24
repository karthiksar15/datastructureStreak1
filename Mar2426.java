public class Mar2426 {

    int[][] matrix;
    int[][] prefixSum;

    public static void main(String[] args) {
        int[][] mat = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } };
        Mar2426 mar = new Mar2426(mat);
        int output = mar.sumRegion(2, 1, 4, 3);
        // int output = mar.sumRegion(1, 1, 2, 2);
        System.out.println("total sum--->" + output);
    }

    public Mar2426(int[][] mat) {
        int R = mat.length;
        int C = mat[0].length;
        this.matrix = mat;
        prefixSum = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                prefixSum[i][j] = matrix[i][j];
                if (i > 0)
                    prefixSum[i][j] += prefixSum[i - 1][j];
                if (j > 0)
                    prefixSum[i][j] += prefixSum[i][j - 1];
                if (i > 0 && j > 0)
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int res = prefixSum[row2][col2];
        if (row1 > 0)
            res = res - prefixSum[row1 - 1][col2];
        if (col1 > 0)
            res = res - prefixSum[row2][col1 - 1];
        if (row1 > 0 && col1 > 0)
            res = res + prefixSum[row1 - 1][col1 - 1]; // add top left
        return res;

    }

}
