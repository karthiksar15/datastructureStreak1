
public class Oct24264 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        int target = 4;
        Oct24264 oct = new Oct24264();
        System.out.println("combination-->" + oct.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int[] d : dp) {
            d[0] = 1;
        }
        for (int i = 1; i <= n; i++)
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] += dp[i][j - nums[i - 1]];
                }
            }
        return dp[n][target];
    }

}
