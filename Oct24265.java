public class Oct24265 {

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2 };
        int target = 4;
        Oct24265 oct = new Oct24265();
        System.out.println("combi 1d--->" + oct.combinationSum4(nums, target));
    }

    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int s : nums) {
                if (i >= s) {
                    dp[i] += dp[i - s];
                }
            }
        }
        return dp[target];
    }

}
