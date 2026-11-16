public class Nov16264 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        Nov16264 nov = new Nov16264();
        System.out.println("canParitions-->" + nov.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i][j];
                }

            }
        }
        return dp[n][target];
    }

}
