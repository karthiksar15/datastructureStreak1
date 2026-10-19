public class Oct182616 {

    public static void main(String[] args) {
        Oct182616 oct = new Oct182616();
        System.out.println("int brak-->" + oct.integerBreak(12));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int num = 2; num <= n; num++) {
            dp[num] = (num == n) ? 0 : num;
            for (int i = 1; i < num; i++) {
                dp[num] = Math.max(dp[num], dp[i] * dp[num - i]);
            }
        }
        return dp[n];
    }

}
