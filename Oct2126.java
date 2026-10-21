public class Oct2126 {

    public static void main(String[] args) {
        Oct2126 oct = new Oct2126();
        int[] nums = { 1, 2, 3, 4 };
        System.out.println("canPartition--->" + oct.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int tot = 0;
        for (int i : nums) {
            tot += i;
        }
        if (tot % 2 != 0)
            return false;
        boolean[][] dp = new boolean[n + 1][tot + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= tot; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][tot];
    }

}
