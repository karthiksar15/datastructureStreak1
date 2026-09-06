public class Sep0626 {

    public static void main(String[] args) {
        String s = "nnn";
        String p = "n*";
        Sep0626 sep = new Sep0626();
        System.out.println("isMatch-->" + sep.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean match = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if ((j + 1) < n && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2];
                    if (match) {
                        dp[i][j] = dp[i + 1][j] || dp[i][j];
                    }
                } else if (match) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}

// o/p
// +---------+-------+-------+-------+
// | Index | 0 | 1 | 2 |
// +---------+-------+-------+-------+
// | Row 0 | true | false | false |
// | Row 1 | true | false | false |
// | Row 2 | true | false | false |
// | Row 3 | true | false | true |
// +---------+-------+-------+-------+