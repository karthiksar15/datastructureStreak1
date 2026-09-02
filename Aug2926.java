class Aug2926 {
    public static void main(String[] args) {
        int amount = 4;
        int[] coins = { 1, 2, 3 };
        Aug2926 aug = new Aug2926();
        System.out.println("change--->" + aug.change(amount, coins));
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int sum = 0;
        for (int c : coins) {
            sum += c;
        }
        int[][] dp = new int[n + 1][sum + 1];
        dp[n][sum] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= coins[i - 1]) {
                    dp[i][j]=
                }
            }
        }
    }
}