import java.util.Arrays;

public class May24269 {

    private int[] memo;

    public static void main(String[] args) {
        int[] nums = { 9, 1, 4, 2, 3, 3, 7 };
        May24269 may = new May24269();
        System.out.println("lengthOfLIS---->" + may.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        int maxLIS = 1;
        for (int i = 0; i < n; i++) {
            maxLIS = Math.max(maxLIS, dfs(nums, i));
        }
        return maxLIS;
    }

    public int dfs(int[] nums, int i) {
        if (memo[i] != -1) {
            return memo[i];
        }
        int LIS = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] < nums[j]) {
                LIS = Math.max(LIS, 1 + dfs(nums, j));
            }
        }
        memo[i] = LIS;
        return LIS;
    }
}
