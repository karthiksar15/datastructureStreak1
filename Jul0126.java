public class Jul0126 {

    public static void main(String[] args) {
        String s = "ababd";
        Jul0126 jul = new Jul0126();
        System.out.println("longest--->" + jul.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int resLen = 0, resIndex = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i - 1][j + 1])) {
                    dp[i][j] = true;
                    if (resLen < j - i + 1) {
                        resLen = j - i + 1;
                        resIndex = i;
                    }
                }
            }
        }
        return s.substring(resIndex, resIndex + resLen);
    }
}
