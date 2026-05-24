import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class May24267 {

    public static void main(String[] args) {
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        May24267 may = new May24267();
        System.out.println("wordbreak--->" + may.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> workSet = new HashSet<>(wordDict);
        return dfs(s, workSet, 0);
    }

    public boolean dfs(String s, Set<String> wordSet, int i) {
        if (i == s.length()) {
            return true;
        }

        for (int j = i; i < s.length(); j++) {
            if (wordSet.contains(s.substring(i, j + 1))) {
                if (dfs(s, wordSet, j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

}
