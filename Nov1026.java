public class Nov1026 {

    public static void main(String[] args) {
        String s = "nnn", p = "n*";
        Nov1026 nov = new Nov1026();
        System.out.println("isMatch--->" + nov.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean isMatch = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < n && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2];
                    if (isMatch) {
                        dp[i][j] = dp[i + 1][j] || dp[i][j];
                    }
                } else if (isMatch) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
