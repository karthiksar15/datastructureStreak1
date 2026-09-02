class Aug2726 {
    public static void main(String[] args) {
        int[] stones = { 2, 4, 1, 5, 6, 3 };
        Aug2726 aug = new Aug2726();
        System.out.println("lastStone--->" + aug.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int s : stones) {
            sum += s;
        }
        int target = sum / 2;
        int[][] dp = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - (2 * dp[n][target]);
    }
}
