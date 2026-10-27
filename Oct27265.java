public class Oct27265 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        Oct27265 oct = new Oct27265();
        System.out.println("can--->" + oct.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int tot = 0;
        for (int i : nums) {
            tot += i;
        }
        if (tot % 2 != 0)
            return false;
        int target = tot / 2;
        int n = nums.length;
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
