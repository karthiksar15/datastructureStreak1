
import java.util.Arrays;

public class Nov16265 {

    public static void main(String[] args) {
        Nov16265 nov = new Nov16265();
        int[] nums = { 9, 1, 4, 2, 3, 3, 7 };
        System.out.println("length--->" + nov.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();

    }

}
