class Sep0126

{
    public static void main(String[] args) {
        int[] piles = { 1, 2, 3, 1 };
        Sep0126 sep = new Sep0126();
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

                int pickLeft = piles[left] - dp[left + 1][right];
                int pickRight = piles[right] - dp[left][right - 1];
                dp[left][right] = Math.max(pickLeft, pickRight);
            }
        }
        return dp[0][n - 1] > 0;
    }
}
