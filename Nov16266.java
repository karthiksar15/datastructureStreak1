import java.util.List;

public class Nov16266 {

    public static void main(String[] args) {
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        Nov16266 nov = new Nov16266();
        System.out.println("wordBreak-->" + nov.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int i = n - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() < s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = true;
                }
                if (dp[i])
                    break;
            }
        }
        return dp[0];
    }

}
