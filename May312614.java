import java.util.Arrays;

public class May312614 {

    int[][] dp;

    public static void main(String[] args) {
        May312614 may = new May312614();
        int[] nums = { 4, 2, 3, 7 };
        System.out.println("maxCoins--->" + may.maxCoins(nums));
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return dfs(newNums, 1, newNums.length - 2, dp);
    }

    public int dfs(int[] nums, int l, int r, int[][] dp) {
        if (l > r)
            return 0;
        if (dp[l][r] != -1)
            return dp[l][r];
        dp[l][r] = 0;
        for (int i = l; i <= r; i++) {
            int coins = nums[l - 1] * nums[i] * nums[r + 1];
            coins += dfs(nums, l, i - 1, dp) + dfs(nums, i + 1, r, dp);
            dp[l][r] = Math.max(dp[l][r], coins);
        }
        return dp[l][r];
    }

}
