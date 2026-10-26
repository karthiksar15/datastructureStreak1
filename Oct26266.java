public class Oct26266 {

    public static void main(String[] args) {
        Oct26266 oct = new Oct26266();
        String s = "abc";
        System.out.println("count-->" + oct.countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i + 1 <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

}
