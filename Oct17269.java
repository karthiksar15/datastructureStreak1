public class Oct17269 {

    public static void main(String[] args) {
        int[] stones = { 2, 4, 1, 5, 6, 3 };
        Oct17269 oct = new Oct17269();
        System.out.println("last-->" + oct.lastStoneWeightII(stones));
    }

    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int total = 0;
        for (int i : stones) {
            total += i;
        }
        int tot = total / 2;
        int[][] dp = new int[n + 1][tot + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= tot; j++) {
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return total - 2 * dp[n][tot];
    }

}
