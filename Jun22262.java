public class Jun22262 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 1, 3 };
        Jun22262 jun = new Jun22262();
        System.out.println("rob--->" + jun.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        if (nums.length == 1)
            dp[0] = nums[0];
        if (nums.length == 2)
            dp[1] = Math.max(nums[1], nums[0]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

}
