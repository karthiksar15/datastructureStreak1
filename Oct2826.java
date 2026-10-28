public class Oct2826 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        int target = 4;
        Oct2826 oct = new Oct2826();
        System.out.println("combi--->" + oct.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int s : nums) {
                if (i - s >= 0) {
                    dp[i] += dp[i - s];
                }

            }
        }
        return dp[target];
    }

}
