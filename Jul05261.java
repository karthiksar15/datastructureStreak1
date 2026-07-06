public class Jul05261 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        Jul05261 jul = new Jul05261();
        System.out.println("canPartition-->" + jul.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int nu : nums) {
            sum += nu;
        }
        if (sum % 2 != 0)
            return false;
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
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
