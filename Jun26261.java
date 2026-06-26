public class Jun26261 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        int target = 4;
        Jun26261 jun = new Jun26261();
        System.out.println("combi--->" + jun.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j : nums) {
                if (i - j >= 0) {
                    dp[i] = dp[i - j] + dp[i];
                }
            }
        }
        return dp[target];
    }

}
