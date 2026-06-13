public class Jun1326 {

    public static void main(String[] args) {
        String s = "appa";
        Jun1326 jun = new Jun1326();
        System.out.println("count-->" + jun.countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

}
