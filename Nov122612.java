public class Nov122612 {

    public static void main(String[] args) {
        int[] stones = { 2, 4, 1, 5, 6, 3 };
        Nov122612 nov = new Nov122612();
        System.out.println("last-->" + nov.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int tot = 0;
        for (int s : stones) {
            tot += s;
        }
        int target = tot / 2;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }
        return tot - 2 * dp[n][target];
    }

}
