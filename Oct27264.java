import java.util.*;

public class Oct27264 {

    public static void main(String[] args) {
        int[] nums = { 9, 1, 4, 2, 3, 3, 7 };
        Oct27264 oct = new Oct27264();
        System.out.println("lengthOfLIS--->" + oct.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        // dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

}
