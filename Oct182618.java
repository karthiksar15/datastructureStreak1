public class Oct182618 {

    public static void main(String[] args) {
        Oct182618 oct = new Oct182618();
        System.out.println("integerBreak-->" + oct.integerBreak(4));
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
