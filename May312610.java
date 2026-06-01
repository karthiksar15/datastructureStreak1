import java.util.Arrays;

public class May312610 {

    int[][] dp;
    int[] suffixSum;

    public static void main(String[] args) {
        int[] piles = { 3, 1, 2, 5, 7 };
        May312610 may = new May312610();
        System.out.println("stone game--->" + may.stoneGameII(piles));
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[n][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        suffixSum = new int[n];
        suffixSum[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = piles[i] + suffixSum[i + 1];
        }
        return dfs(0, 1);
    }

    public int dfs(int i, int M) {
        if (i == suffixSum.length)
            return 0;
        if (dp[i][M] != -1)
            return dp[i][M];
        int res = 0;
        for (int x = 1; x <= 2 * M; x++) {
            if (i + x > suffixSum.length)
                break;
            res = Math.max(res, suffixSum[i] - dfs(i + x, Math.max(M, x)));
        }
        return dp[i][M] = res;
    }

}
