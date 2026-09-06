class Aug3026 {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 2 };
        int target = 2;
        Aug3026 aug = new Aug3026();
        System.out.println("findTarget--->" + aug.findTargetSumWays(nums, target));
    }

    // This transition logic (dp[i - 1][j - nums[i - 1]]) represents the 0/1
    // Knapsack problem, where you can use each item (or nums) at most once.

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (Math.abs(target) > sum || (target + sum) % 2 != 0) {
            return 0;
        }
        int subset = (target + sum) / 2;
        int[][] dp = new int[n + 1][subset + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }
}

// o/p:
// 2D array
// +---------+-----+-----+-----+-----+-----+
// | Index | 0 | 1 | 2 | 3 | 4 |
// +---------+-----+-----+-----+-----+-----+
// | Row 0 | 1 | 0 | 0 | 0 | 0 |
// | Row 1 | 1 | 0 | 1 | 0 | 0 |
// | Row 2 | 1 | 0 | 2 | 0 | 0 |
// | Row 3 | 1 | 0 | 3 | 0 | 0 |
// +---------+-----+-----+-----+-----+-----+
