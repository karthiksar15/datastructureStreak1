class Nov1726 {
    public static void main(String[] args) {
        Nov1726 nov = new Nov1726();
        int[] stoneValue = { 2, 4, 3, 1 };
        System.out.println("stonegame-->" + nov.stoneGameIII(stoneValue));
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int tot = 0;
            for (int j = i; j < Math.min(i + 3, n); j++) {
                tot += stoneValue[j];
                dp[i] = Math.max(dp[i], tot - dp[j + 1]);
            }
        }
        int result = dp[0];
        if (result == 0)
            return "Tie";
        return result > 0 ? "alice" : "Bob";
    }

}