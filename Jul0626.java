public class Jul0626 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        Jul0626 jul = new Jul0626();
        System.out.println("combiii--->" + jul.combinationSum4(nums, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }

            }
        }
        return dp[target];
    }

}
