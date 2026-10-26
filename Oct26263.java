public class Oct26263 {

    public static void main(String[] args) {
        int[] nums = { 2, 9, 8, 3, 6 };
        Oct26263 oct = new Oct26263();
        System.out.println("rob--->" + oct.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        dp[n] = Math.max(dp[n - 1], dp[n - 2]);
        return dp[n];
    }

}
