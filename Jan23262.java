import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jan23262 {

    public static void main(String[] args) {
        Jan23262 jan = new Jan23262();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("ladderLength---->" + jan.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return 0;
        if (beginWord.equalsIgnoreCase(endWord))
            return 1;
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        int level = 1;
        int L = beginWord.length();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < L; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original)
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
