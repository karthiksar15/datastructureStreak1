public class Sep07264 {

    public static void main(String[] args) {
        int[] stones = { 2, 4, 1, 5, 6, 3 };
        Sep07264 sep = new Sep07264();
        System.out.println("last stone--->" + sep.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        int m = stones.length;
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = sum / 2;
        int[][] dp = new int[m + 1][target + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[m][target];
    }

}

// op:
// { 2, 4, 1, 5 };
// 2D array
// +---------+-----+-----+-----+-----+-----+-----+-----+
// | Index | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
// +---------+-----+-----+-----+-----+-----+-----+-----+
// | Row 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
// | Row 1 | 0 | 0 | 2 | 2 | 2 | 2 | 2 |
// | Row 2 | 0 | 0 | 2 | 2 | 4 | 4 | 6 |
// | Row 3 | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
// | Row 4 | 0 | 1 | 2 | 3 | 4 | 5 | 6 |
// +---------+-----+-----+-----+-----+-----+-----+-----+
