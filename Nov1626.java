public class Nov1626 {

    public static void main(String[] args) {
        Nov1626 nov = new Nov1626();
        int[] stoneValue = { 2, 4, 3, 1 };
        System.out.println("stoneGame-->" + nov.stoneGameIII(stoneValue));
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int tot = 0;
            for (int j = i; j < n; j++) {
                tot += stoneValue[j];
                dp[i] = Math.max(dp[i], tot - dp[j + 1]);
            }
        }
        int res = dp[0];
        if (res == 0)
            return "Tie";
        return res > 0 ? "abh" : "bob";
    }

}
