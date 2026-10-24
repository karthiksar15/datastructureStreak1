
class Oct24263 {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        Oct24263 oct = new Oct24263();
        System.out.println("canPart--->" + oct.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int tot = 0;
        for (int i : nums) {
            tot += i;
        }
        int tartget = tot / 2;
        if (tot % 2 != 0)
            return false;
        boolean[][] dp = new boolean[n + 1][tartget + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= tartget; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i][j];
                }
            }
        }
        return dp[n][tartget];
    }
}