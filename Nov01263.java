public class Nov01263 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        int target = 4;
        Nov01263 nov = new Nov01263();
        System.out.println("combi--->" + nov.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int s : nums) {
                if (s <= i) {
                    dp[i] += dp[i - s];
                }
            }
        }
        return dp[target];
    }

}
