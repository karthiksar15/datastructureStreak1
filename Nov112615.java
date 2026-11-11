import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Nov112615 {

    public static void main(String[] args) {
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        Nov112615 nov = new Nov112615();
        System.out.println("wordBreak--->" + nov.wordBreak(s, wordDict));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        backtrack(result, set, s, new ArrayList<>(), 0);
        return result;
    }

    public void backtrack(List<String> result, Set<String> set, String s, List<String> cur, int i) {
        if (i == s.length()) {
            result.add(String.join(" ", cur));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            String w = s.substring(i, j + 1);
            if (set.contains(w)) {
                cur.add(w);
                backtrack(result, set, s, cur, j + 1);
                cur.remove(cur.size() - 1);
            }
        }

    }

}
