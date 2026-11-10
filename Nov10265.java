public class Nov10265 {

    public static void main(String[] args) {
        int[] piles = { 3, 1, 2, 5, 7 };
        Nov10265 nov = new Nov10265();
        System.out.println("stone game-->" + nov.stoneGameII(piles));
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] pref = new int[n + 1];
        pref[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            pref[i] = pref[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = pref[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        int cost = dp[i + x][Math.max(m, x)];
                        dp[i][m] = Math.max(dp[i][m], pref[i] - cost);
                    }
                }
            }
        }
        return dp[0][1];
    }

}
