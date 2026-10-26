public class Oct26265 {

    public static void main(String[] args) {
        String s = "abbc";
        Oct26265 oct = new Oct26265();
        System.out.println("longest--->" + oct.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        int res = 0, resLen = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[i + 1][j - 1])) {
                    if (j - i + 1 > resLen) {
                        res = i;
                        resLen = j - i + 1;
                    }
                    dp[i][j] = true;
                }
            }
        }
        return s.substring(res, res + resLen);
    }

}
