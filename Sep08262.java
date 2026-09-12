public class Sep08262 {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2 };
        int target = 2;
        Sep08262 sep = new Sep08262();
        System.out.println("findTarget--->" + sep.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int newTarget = (sum + target) / 2;
        int[][] dp = new int[n + 1][newTarget + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= newTarget; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][newTarget];
    }
}
