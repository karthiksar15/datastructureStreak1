public class Sep1126 {

    public static void main(String[] args) {
        Sep1126 sep = new Sep1126();
        int[] piles = { 1, 2, 3, 1 };
        System.out.println("stone game--->" + sep.stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int left = 0; left <= n - len; left++) {
                int right = left + len - 1;
                int mxLeft = piles[left] + dp[left + 1][right];
                int mxRight = piles[right] + dp[left][right - 1];
                dp[left][right] = Math.max(mxLeft, mxRight);
            }
        }
        return dp[0][n - 1] > 0;
    }
}
