import java.util.Arrays;

public class Nov23264 {

    public static void main(String[] args) {
        int[] nums = { 9, 1, 4, 2, 3, 3, 7 };
        Nov23264 nov = new Nov23264();
        System.out.println("length-->" + nov.lengthOfLIS(nums));
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
