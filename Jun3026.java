public class Jun3026 {

    public static void main(String[] args) {
        int[] nums = { 2, 9, 8, 3, 6 };
        Jun3026 jun = new Jun3026();
        System.out.println("rob--->" + jun.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = nums[0];
        // 1 as robbed from first house
        for (int i = 2; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i - 2][0] + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 2][1] + nums[i], dp[i - 1][1]);
        }

        int last = n - 1;
        dp[last][0] = Math.max(dp[last - 1][0], dp[last - 2][0] + nums[last]);
        dp[last][1] = dp[last - 1][1];

        return Math.max(dp[last][0], dp[last][1]);
    }

}
