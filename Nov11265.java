public class Nov11265 {

    public static void main(String[] args) {
        int[] piles = { 3, 1, 2, 5, 7 };
        Nov11265 nov = new Nov11265();
        System.out.println("stonegame--->" + nov.stoneGameII(piles));
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n + 1];
        int[] prefix = new int[n];
        prefix[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            prefix[i] = prefix[i + 1] + piles[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                if (i + 2 * m >= n) {
                    dp[i][m] = prefix[i];
                } else {
                    for (int x = 1; x <= 2 * m; x++) {
                        int stones = dp[i + x][Math.max(x, m)];
                        dp[i][m] = Math.max(dp[i][m], prefix[i] - stones);
                    }
                }
            }
        }
        return dp[0][1];
    }

}
