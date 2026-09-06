public class Sep0326 {

    public static void main(String[] args) {
        String s = "caaat", t = "cat";
        Sep0326 sep = new Sep0326();
        System.out.println("numDistinct--->" + sep.numDistinct(s, t));
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}

// o/p:
// +---------+-----+-----+-----+-----+
// | Index | 0 | 1 | 2 | 3 |
// +---------+-----+-----+-----+-----+
// | Row 0 | 3 | 3 | 1 | 1 |
// | Row 1 | 0 | 3 | 1 | 1 |
// | Row 2 | 0 | 2 | 1 | 1 |
// | Row 3 | 0 | 1 | 1 | 1 |
// | Row 4 | 0 | 0 | 1 | 1 |
// | Row 5 | 0 | 0 | 0 | 1 |
// +---------+-----+-----+-----+-----+
