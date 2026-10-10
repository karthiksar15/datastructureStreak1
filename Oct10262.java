public class Oct10262 {

    public static void main(String[] args) {
        Oct10262 oct = new Oct10262();
        int[] nums = { 2, 9, 8, 3, 6 };
        System.out.println("rob---->" + oct.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = nums[1];
        dp[1][1] = nums[0];
        for (int i = 2; i < n - 1; i++) {
            dp[i][0] = Math.max(dp[i - 2][0] + nums[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 2][1] + nums[i], dp[i - 1][1]);
        }
        int last = n - 1;
        dp[last][0] = Math.max(dp[last - 1][0], dp[last - 2][0] + nums[last]);
        dp[last][1] = dp[last - 1][1];
        return Math.max(dp[last][1], dp[last][0]);
    }

}
