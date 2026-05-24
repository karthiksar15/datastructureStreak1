import java.util.Arrays;

public class May242614 {

    public static void main(String[] args) {
        int n = 12;
        May242614 may = new May242614();
        System.out.println("integerBreak--->" + may.integerBreak(n));
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
