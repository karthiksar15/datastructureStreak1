import java.util.Arrays;

public class Jun2626 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        Jun2626 jun = new Jun2626();
        System.out.println("canPartition--->" + jun.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        int mid = sum / 2;
        if (sum % 2 != 0)
            return false;
        boolean[][] dp = new boolean[n + 1][mid + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= mid; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][mid];
    }

}
