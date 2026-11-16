public class Nov16263 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        int target = 4;
        Nov16263 nov = new Nov16263();
        System.out.println("combi-->" + nov.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
