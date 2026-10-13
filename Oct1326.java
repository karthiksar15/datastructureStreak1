public class Oct1326 {

    public static void main(String[] args) {
        int[] piles = { 3, 1, 2, 5, 7 };
        Oct1326 oct = new Oct1326();
        System.out.println("stoneGame-->" + oct.stoneGameII(piles));
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] prefixSum = new int[n];
        prefixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefixSum[i] = piles[i] + prefixSum[i + 1];
        }
        int[][] dp = new int[n][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = prefixSum[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        int opp = dp[i + x][Math.max(x, m)];
                        dp[i][m] = Math.max(dp[i][m], prefixSum[i] - opp);
                    }
                }
            }
        }
        return dp[0][1];
    }

}
