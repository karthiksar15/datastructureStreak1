public class Jul09268 {

    public static void main(String[] args) {
        int[] piles = { 1, 2, 3, 1 };
        Jul09268 jul = new Jul09268();
        System.out.println("stonegame--->" + jul.stoneGame(piles));
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int sum = 0;
        for (int p : piles)
            sum += p;
        int[][] dp = new int[n][n];

        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                boolean even = (r - l) % 2 == 0;
                int left = even ? piles[l] : 0;
                int right = even ? piles[r] : 0;
                if (l == r) {
                    dp[l][r] = left;
                } else {
                    dp[l][r] = Math.max(dp[l + 1][r] + left, dp[l][r - 1] + right);
                }
            }
        }

        int alice = dp[0][n - 1];
        return alice > sum - alice;
    }

}
