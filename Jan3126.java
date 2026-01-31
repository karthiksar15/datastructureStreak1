import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jan3126 {

    public static void main(String[] args) {
        Jan3126 jan = new Jan3126();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("jan----" + jan.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return 0;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        int n = beginWord.length();
        int result = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            Set<String> nextLevel = new HashSet<>();
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            for (String s : beginSet) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < n; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (original == c)
                            continue;
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord))
                            return result + 1;
                        if (dict.contains(newWord) && visited.add(newWord)) {
                            nextLevel.add(newWord);
                        }
                    }
                    chars[i] = original;
                }
            }
            beginSet = nextLevel;
            result++;
        }
        return 0;
    }

}
