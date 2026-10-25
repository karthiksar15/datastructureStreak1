public class Oct25263 {

    public static void main(String[] args) {
        int[] piles = { 3, 1, 2, 5, 7 };
        Oct25263 oct = new Oct25263();
        System.out.println("stoneGame--->" + oct.stoneGameII(piles));
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffix = new int[n + 1];
        suffix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = suffix[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        int oppBes = dp[i + x][Math.max(x, m)];
                        dp[i][m] = Math.max(dp[i][m], suffix[i] - oppBes);
                    }
                }
            }
        }
        return dp[0][1];
    }

}
