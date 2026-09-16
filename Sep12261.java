public class Sep12261 {

    public static void main(String[] args) {
        int[] piles = { 3, 1, 2, 5, 7 };
        Sep12261 sep = new Sep12261();
        System.out.println("stone game--->" + sep.stoneGameII(piles));
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[2][n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                int total = 0;
                dp[1][i][m] = 0;
                dp[0][i][m] = Integer.MAX_VALUE;
                for (int j = 1; j <= 2 * m; j++) {
                    if (i + j > n)
                        break;
                    total += piles[i + j - 1];
                    dp[1][i][m] = Math.max(dp[1][i][m], total + dp[0][i + j][Math.max(m, j)]);
                    dp[0][i][m] = Math.min(dp[0][i][m], dp[1][i + j][Math.max(m, j)]);
                }
            }
        }
        return dp[1][0][1];
    }

}
