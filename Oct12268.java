public class Oct12268 {

    public static void main(String[] args) {
        int[] piles = { 1, 2, 3, 1 };
        Oct12268 oct = new Oct12268();
        System.out.println("stone game--->" + oct.stoneGame(piles));
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
                int leftMax = piles[left] - dp[left + 1][right];
                int rightMax = piles[right] - dp[left][right - 1];
                dp[left][right] = Math.max(leftMax, rightMax);
            }
        }

        return dp[0][n - 1] > 0;
    }

}
