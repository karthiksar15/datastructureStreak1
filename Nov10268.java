public class Nov10268 {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2 };
        int target = 2;
        Nov10268 nov = new Nov10268();
        System.out.println("findTarget--->" + nov.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int tot = 0;
        for (int i : nums) {
            tot += i;
        }
        int subset = (tot + target) / 2;
        int[][] dp = new int[n + 1][subset + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= subset; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][subset];
    }

}
