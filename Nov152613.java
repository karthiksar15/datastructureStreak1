public class Nov152613 {

    public static void main(String[] args) {
        Nov152613 nov = new Nov152613();
        String a = "aaa";
        System.out.println("count-->" + nov.countSubstrings(a));
    }

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        dp[n][n] = true;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i] = dp[i + 1];
                if (s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[i + 1][j])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

}
