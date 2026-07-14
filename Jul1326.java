public class Jul1326 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 3 };
        Jul1326 jul = new Jul1326();
        System.out.println("rob---->" + jul.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = nums[0];

        for (int i = 2; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 2][0] + nums[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][1] + nums[i]);
        }
        int last = n - 1;
        dp[last][0] = Math.max(dp[last - 1][0], dp[last - 2][0] + nums[last]);
        dp[last][1] = dp[last - 1][1];
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

}
