import java.util.List;

public class Jun1626 {

    public static void main(String[] args) {
        Jun1626 jun = new Jun1626();
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        System.out.println("wordBreak-->" + jun.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if ((i + word.length()) <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i])
                    break;
            }
        }
        return dp[0];
    }

}
