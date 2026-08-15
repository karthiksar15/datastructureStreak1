public class Aug14265 {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2 };
        int target = 2;
        Aug14265 aug = new Aug14265();
        System.out.println("target--->" + aug.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        int subset = (totalSum + target) / 2;
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
