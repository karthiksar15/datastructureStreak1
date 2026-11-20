public class Nov20261 {

    public static void main(String[] args) {
        int[] nums = { 4, 2, 3, 7 };
        Nov20261 nov = new Nov20261();
        System.out.println("maxCoins-->" + nov.maxCoins(nums));
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            newNums[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                for (int m = i; m <= j; m++) {
                    int coins = newNums[i - 1] * newNums[m] * newNums[j + 1];
                    coins += dp[i][m - 1] + dp[m + 1][j];
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[1][n];
    }

}
