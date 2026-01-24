import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jan2426 {

    public static void main(String[] args) {
        Jan2426 jan = new Jan2426();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("ladder length--->" + jan.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        if (!dict.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        int L = beginWord.length();
        int level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> nextLevel = new HashSet<>();

            for (String str : beginSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < L; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (chars[i] == c)
                            continue;
                        chars[i] = c;
                        String candidate = new String(chars);
                        if (endSet.contains(candidate)) {
                            return level + 1;
                        }
                        if (dict.contains(candidate) && visited.add(candidate)) {
                            nextLevel.add(candidate);
                        }
                    }
                    chars[i] = original;
                }
            }
            beginSet = nextLevel;
            level++;
        }
        return 0;
    }

}
