public class Nov15266 {

    public static void main(String[] args) {
        Nov15266 nov = new Nov15266();
        int[] nums = { 3, 1, 2 };
        int target = 4;
        System.out.println("combii->" + nov.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
