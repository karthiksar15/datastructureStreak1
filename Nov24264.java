public class Nov24264 {

    public static void main(String[] args) {
        int[] stones = { 2, 4, 1, 5, 6, 3 };
        Nov24264 nov = new Nov24264();
        System.out.println("last stone--->" + nov.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int tot = 0;
        for (int i : stones) {
            tot += i;
        }
        int target = tot / 2;
        int[][] dp = new int[n + 1][target + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {

                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return tot - (2 * dp[n][target]);
    }

}
