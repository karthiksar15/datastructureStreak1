import java.util.List;

public class Nov17266 {

    public static void main(String[] args) {
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        Nov17266 nov = new Nov17266();
        System.out.println("wordBreak-->" + nov.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (String str : wordDict) {
                if (i + str.length() <= s.length() && s.substring(i, i + str.length()).equals(str)) {
                    dp[i] = dp[i + str.length()];
                }
                if (dp[i])
                    break;
            }
        }
        return dp[0];
    }

}
