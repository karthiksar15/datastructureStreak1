import java.util.Arrays;

public class Nov12264 {

    public static void main(String[] args) {
        int[] nums = { 2, 9, 8, 3, 6 };
        Nov12264 nov = new Nov12264();
        System.out.println("rob--->" + nov.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(helper(Arrays.copyOfRange(nums, 0, n - 1)), helper(Arrays.copyOfRange(nums, 1, n)));
    }

    public int helper(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[2] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        dp[n] = Math.max(dp[n - 1], dp[n - 2]);
        return dp[n];
    }

}
