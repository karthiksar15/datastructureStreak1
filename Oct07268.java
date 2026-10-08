class Oct07268 {
    public static void main(String[] args) {
        Oct07268 oct = new Oct07268();
        int[] nums = { 4, 2, 3, 7 };
        System.out.println("maxCoins--->" + oct.maxCoins(nums));
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] suffixSum = new int[n + 2];
        suffixSum[0] = 1;
        suffixSum[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            suffixSum[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int l = n; l >= 1; l--) {
            for (int r = l; r <= n; r++) {
                for (int i = l; i <= r; i++) {
                    int coins = suffixSum[l - 1] * suffixSum[i] * suffixSum[r + 1];
                    coins += dp[l][i - 1] + dp[i + 1][r];
                    dp[l][r] = Math.max(dp[l][r], coins);
                }
            }
        }
        return dp[1][n];
    }
}