public class Oct10261 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 3, 3 };
        Oct10261 oct = new Oct10261();
        System.out.println("rob--->" + oct.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

}
