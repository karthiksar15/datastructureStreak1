class Sep0926 {

    public static void main(String[] args) {
        int[] stones = { 2, 4, 1, 5, 6, 3 };
        Sep0926 sep = new Sep0926();
        System.out.println("lastStone--->" + sep.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = (sum / 2);
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
