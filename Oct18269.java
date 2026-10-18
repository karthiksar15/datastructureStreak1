public class Oct18269 {

    public static void main(String[] args) {
        String s = "1012";
        Oct18269 oct = new Oct18269();
        System.out.println("numDecodings--->" + oct.numDecodings(s));
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < n && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

}
