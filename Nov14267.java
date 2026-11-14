public class Nov14267 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        Nov14267 nov = new Nov14267();
        System.out.println("Can--->" + nov.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int tot = 0;
        for (int i : nums) {
            tot += i;
        }
        int target = tot / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i][j];
                }
            }
        }
        return dp[n][target];
    }

}
