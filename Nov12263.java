public class Nov12263 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 3, 3 };
        Nov12263 nov = new Nov12263();
        System.out.println("rob--->" + nov.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        dp[n] = Math.max(dp[n - 1], dp[n - 2]);
        return dp[n];
    }

}
