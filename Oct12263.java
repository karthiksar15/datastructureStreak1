public class Oct12263 {

    public static void main(String[] args) {
        int[] stones = { 2, 4, 1, 5, 6, 3 };
        Oct12263 oct = new Oct12263();
        System.out.println("lastStone-->" + oct.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        int m = stones.length;
        int total = 0;
        for (int i : stones) {
            total += i;
        }
        int target = total / 2;
        int[][] dp = new int[m + 1][target + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= target; j++) {
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - stones[i - 1]] + stones[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return (total - 2 * dp[m][target]);
    }

}
