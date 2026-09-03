class Aug3026 {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 2 };
        int target = 2;
        Aug3026 aug = new Aug3026();
        System.out.println("findTarget--->" + aug.findTargetSumWays(nums, target));
    }

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