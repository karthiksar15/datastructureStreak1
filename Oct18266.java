public class Oct18266 {

    public static void main(String[] args) {
        String s = "ababd";
        Oct18266 oct = new Oct18266();
        System.out.println("longest palindrome--->" + oct.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        int resIdx = 0, resLen = 0;
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (resLen < j - i + 1) {
                        resIdx = i;
                        resLen = j - i + 1;
                    }
                }
            }
        }
        return s.substring(resIdx, resIdx + resLen);
    }

}
