public class Nov112611 {

    public static void main(String[] args) {
        Nov112611 nov = new Nov112611();
        int[] nums = { 3, 1, 2 };
        int target = 4;
        System.out.println("combination--->" + nov.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
