import java.util.Arrays;

public class Oct26264 {
    public static void main(String[] args) {
        int[] nums = { 2, 9, 8, 3, 6 };
        Oct26264 oct = new Oct26264();
        int n = nums.length;
        System.out.println("rob-->"
                + Math.max(oct.rob(Arrays.copyOfRange(nums, 0, n - 1)),
                        oct.rob(Arrays.copyOfRange(nums, 1, n))));
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
