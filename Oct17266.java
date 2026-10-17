public class Oct17266 {

    public static void main(String[] args) {
        Oct17266 oct = new Oct17266();
        int[] nums = { 2, 2, 2 };
        int target = 2;
        System.out.println("findTarget--->" + oct.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int subset = sum + target;
        if (subset % 2 != 0 || target > sum)
            return 0;
        int set = subset / 2;
        int[][] dp = new int[n + 1][set + 1];
        for (int[] d : dp) {
            d[0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= set; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][set];
    }

}
