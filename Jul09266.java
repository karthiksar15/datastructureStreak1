public class Jul09266 {

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2 };
        int target = 2;
        Jul09266 jul = new Jul09266();
        System.out.println("findTarget--->" + jul.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (Math.abs(target) > totalSum)
            return 0;

        int n = nums.length;
        int[][] dp = new int[n + 1][2 * totalSum + 1];
        dp[0][totalSum] = 1;
        for (int i = 0; i < n; i++) {
            for (int sum = -totalSum; sum <= totalSum; sum++) {
                if (dp[i][sum + totalSum] > 0) {
                    dp[i + 1][sum + nums[i] + totalSum] += dp[i][sum + totalSum];
                    dp[i + 1][sum - nums[i] + totalSum] += dp[i][sum + totalSum];
                }
            }
        }
        return dp[n][target + totalSum];
    }

}
