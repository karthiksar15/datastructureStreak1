public class Nov152612 {

    public static void main(String[] args) {
        Nov152612 nov = new Nov152612();
        String s = "12";
        System.out.println("numDecodings-->" + nov.numDecodings(s));
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];
            if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }

}
