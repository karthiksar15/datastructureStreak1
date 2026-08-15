public class Aug1526 {

    public static void main(String[] args) {
        Aug1526 aug = new Aug1526();
        int[] piles = { 3, 1, 2, 5, 7 };
        System.out.println("stone game--->" + aug.stoneGameII(piles));
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int m = 1; m <= n; m++) {
                for (int x = 1; x <= 2 * m; x++) {
                    if (i + x > n)
                        break;
                    dp[i][m] = Math.max(dp[i][m], suffixSum[i] - dp[i + x][Math.max(m, x)]);
                }
            }
        }
        return dp[0][1];
    }
}
