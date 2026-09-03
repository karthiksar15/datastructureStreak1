public class Aug3126 {

    public static void main(String[] args) {
        String s1 = "", s2 = "", s3 = "";
        Aug3126 aug = new Aug3126();
        System.out.println("isInterleave--->" + aug.isInterleave(s1, s2, s3));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), o = s3.length();
        if (o != m + n)
            return false;
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i < m && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]) {
                    dp[i][j] = true;
                }
                if (j < n && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }
        return dp[0][0];
    }

}
