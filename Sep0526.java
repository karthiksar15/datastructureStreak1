public class Sep0526 {

    public static void main(String[] args) {
        int[] nums = { 4, 2, 3, };
        Sep0526 sep = new Sep0526();
        System.out.println("maxCoins--->" + sep.maxCoins(nums));
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int l = n; l >= 1; l--) {
            for (int r = l; r <= n; r++) {
                for (int i = l; i <= r; i++) {
                    int coins = newNums[l - 1] * newNums[i] * newNums[r + 1];
                    coins += dp[l][i - 1] + dp[i + 1][r];
                    dp[l][r] = Math.max(dp[l][r], coins);
                }
            }
        }
        return dp[1][n];
    }

}

// o/p:
// +---------+-----+-----+-----+-----+-----+
// | Index | 0 | 1 | 2 | 3 | 4 |
// +---------+-----+-----+-----+-----+-----+
// | Row 0 | 0 | 0 | 0 | 0 | 0 |
// | Row 1 | 0 | 8 | 36 | 40 | 0 |
// | Row 2 | 0 | 0 | 24 | 36 | 0 |
// | Row 3 | 0 | 0 | 0 | 6 | 0 |
// | Row 4 | 0 | 0 | 0 | 0 | 0 |
// +---------+-----+-----+-----+-----+-----+