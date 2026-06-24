public class Jun2426 {

    public static void main(String[] args) {
        String s = "12";
        Jun2426 jun = new Jun2426();
        System.out.println("numDecodings--->" + jun.numDecodings(s));
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < n && ((s.charAt(i) == '1' || s.charAt(i) == '2') && s.charAt(i + 1) <= '6')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

}
