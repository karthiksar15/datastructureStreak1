public class Nov152614 {

    public static void main(String[] args) {
        String s = "ababd";
        Nov152614 nov = new Nov152614();
        System.out.println("longest pali-->" + nov.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[n][n] = true;
        int len = 0, idx = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > len) {
                        len = j - i + 1;
                        idx = i;
                    }
                }
            }
        }
        return s.substring(idx, idx + len);

    }

}
