public class Oct18267 {

    public static void main(String[] args) {
        String s = "ababd";
        Oct18267 oct = new Oct18267();
        System.out.println("longest Palindrome--->" + oct.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int[] p = manacher(s);
        int resLen = 0, center_idx = 0;
        for (int i = 0; i < p.length; i++) {
            if (p[i] > resLen) {
                resLen = p[i];
                center_idx = i;
            }
        }
        int resIdx = (center_idx - resLen) / 2;
        return s.substring(resIdx, resIdx + resLen);
    }

    public int[] manacher(String s) {
        StringBuilder sb = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        int n = sb.length();
        int[] dp = new int[n];
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = (i < r) ? Math.min(r - i, dp[l + (r - i)]) : 0;
            while (i + dp[i] + 1 < n && i - dp[i] - 1 >= 0 && sb.charAt(i + dp[i] + 1) == sb.charAt(i - dp[i] - 1)) {
                dp[i]++;
            }
            if (i + dp[i] > r) {
                l = i - dp[i];
                r = i + dp[i];
            }
        }
        return dp;
    }

}
