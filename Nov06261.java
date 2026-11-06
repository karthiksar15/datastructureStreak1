public class Nov06261 {

    public static void main(String[] args) {
        int[] piles = { 3, 1, 2, 5, 7 };
        Nov06261 nov = new Nov06261();
        System.out.println("stone game-->" + nov.stoneGameII(piles));
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] prefix = new int[n];
        prefix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefix[i] = prefix[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = prefix[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        int cost = dp[i + x][Math.max(x, m)];
                        dp[i][m] = Math.max(dp[i][m], prefix[i] - cost);
                    }
                }
            }
        }
        return dp[0][1];
    }

}
