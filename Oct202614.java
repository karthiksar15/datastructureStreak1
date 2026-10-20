public class Oct202614 {

    public static void main(String[] args) {
        String s = "nnn", p = "n*";
        Oct202614 oct = new Oct202614();
        System.out.println("isMatch-->" + oct.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        // dp[m][n] = true;
        dp[m][n] = true;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean match = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < n && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2];
                    if (match) {
                        dp[i][j] = dp[i + 1][j] || dp[i][j];
                    }
                } else if (match) {
                    dp[i][j] = dp[i + 1][j + 1];
                }

            }
        }
        // for (int i = m; i >= 0; i--) {
        // for (int j = n; j >= 0; j--) {
        // boolean match = i < m && j < n && (s.charAt(i) == p.charAt(j) || p.charAt(j)
        // == '.');
        // if (j + 1 < n && p.charAt(j + 1) == '*') {
        // dp[i][j] = dp[i][j + 2];
        // if (match) {
        // dp[i][j] = dp[i + 1][j] || dp[i][j];
        // }
        // } else if (match) {
        // dp[i][j] = dp[i + 1][j + 1];
        // }

        // }
        // }
        return dp[0][0];
    }

}
