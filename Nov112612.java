public class Nov112612 {

    public static void main(String[] args) {
        Nov112612 nov = new Nov112612();
        int[] nums = { 1, 2, 3, 4 };
        System.out.println("canPartition-->" + nov.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int tot = 0;
        for (int i : nums) {
            tot += i;
        }
        if (tot % 2 != 0)
            return false;
        int target = tot / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i][j];
                }
            }
        }
        return dp[n][target];
    }

}
