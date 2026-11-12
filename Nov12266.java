public class Nov12266 {

    public static void main(String[] args) {
        String s = "aaa";
        Nov12266 nov = new Nov12266();
        System.out.println("count-->" + nov.countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;
    }

}
