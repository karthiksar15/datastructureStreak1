public class Oct182615 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        int target = 4;
        Oct182615 oct = new Oct182615();
        System.out.println("combiSum--->" + oct.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i - n >= 0) {
                    dp[i] += dp[i - n];
                }
            }
        }
        return dp[target];
    }

}
