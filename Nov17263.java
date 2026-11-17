public class Nov17263 {

    public static void main(String[] args) {
        Nov17263 nov = new Nov17263();
        int[] nums = { 3, 1, 2 };
        int target = 4;
        System.out.println("combi-->" + nov.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }

}
