class Oct07263 {

    public static void main(String[] args) {
        int[] piles = { 1, 2, 3, 1 };
        Oct07263 oct = new Oct07263();
        System.out.println("stone game-->" + oct.stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int left = 0; left < n - len; left++) {
                int right = left + len - 1;
                int pickLeft = piles[left] - dp[left + 1][right];
                int pickRight = piles[right] - dp[left][right - 1];
                dp[left][right] = Math.max(pickLeft, pickRight);
            }
        }
        return dp[0][n - 1] > 0;
    }
}