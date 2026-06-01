import java.util.Arrays;

public class May31269 {

    private int[][] dp;

    public static void main(String[] args) {
        May31269 may = new May31269();
        int[] piles = { 1, 2, 3, 1 };
        System.out.println("stonegame--->" + may.stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        dp = new int[n][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int total = 0;
        for (int p : piles) {
            total += p;
        }
        int aliceScore = dfs(0, n - 1, piles);
        return aliceScore > total - aliceScore;
    }

    private int dfs(int l, int r, int[] piles) {
        if (l > r)
            return 0;
        if (dp[l][r] != -1)
            return dp[l][r];
        boolean even = (r - l) % 2 == 0;
        int left = even ? piles[l] : 0;
        int right = even ? piles[r] : 0;
        dp[l][r] = Math.max(dfs(l + 1, r, piles) + left, dfs(l, r - 1, piles) + right);
        return dp[l][r];
    }

}
