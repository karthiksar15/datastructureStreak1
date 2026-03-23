public class Mar23261 {

    private int[][] pre;

    public static void main(String[] args) {
        int[][] mat = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 }, { 1, 0, 3, 0, 5 } };
        Mar23261 mar = new Mar23261(mat);
        int output = mar.sumRegion(2, 1, 4, 3);
        // int output = mar.sumRegion(1, 1, 2, 2);
        System.out.println("total sum--->" + output);
    }

    public Mar23261(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        pre = new int[R + 1][C + 1];
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                pre[i][j] = matrix[i - 1][j - 1] + pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return pre[row2 + 1][col2 + 1] - pre[row1][col2 + 1] - pre[row2 + 1][col1] + pre[row1][col1];
    }

}
