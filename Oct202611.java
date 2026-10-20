public class Oct202611 {

    public static void main(String[] args) {
        String s = "caaam", t = "cag";
        Oct202611 oct = new Oct202611();
        System.out.println("numDistinct--->" + oct.numDistinct(s, t));
    }

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[m][n] = 1;
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
