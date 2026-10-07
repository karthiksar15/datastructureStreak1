class Oct0526 {
    public static void main(String[] args) {
        int[] stones = { 2, 4, 1, 5, 6, 3 };
        Oct0526 oct = new Oct0526();
        System.out.println("lastStone--->" + oct.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        int n = stones.length;
        for (int s : stones) {
            totalSum += s;
        }
        int target = totalSum / 2;
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
        return totalSum - (2 * dp[n][target]);
    }
}