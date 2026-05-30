import java.util.List;

public class May302612 {

    public static void main(String[] args) {
        May302612 may = new May302612();
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        System.out.println("word break--->" + may.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {

            }
        }
    }

}
