public class Jul11264 {

    public static void main(String[] args) {
        Jul11264 jul = new Jul11264();
        int[] nums = { 1, 2, 3, 4 };
        System.out.println("canPartition--->" + jul.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int s : nums) {
            sum += s;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;

        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i : nums)
            dp[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        return dp[n][target];
    }

}
