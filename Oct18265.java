import java.util.Arrays;

public class Oct18265 {

    public static void main(String[] args) {
        int[] nums = { 2, 9, 8, 3, 6 };
        Oct18265 oct = new Oct18265();
        System.out.println("rob--->" + oct.rob(nums));
    }

    public int rob(int[] nums) {
        return Math.max(helper(Arrays.copyOfRange(nums, 1, nums.length)),
                helper(Arrays.copyOfRange(nums, 0, nums.length - 1)));
    }

    public int helper(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

}
