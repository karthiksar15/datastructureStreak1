import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jan2926 {

    public static void main(String[] args) {
        Jan2926 jan = new Jan2926();
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("ladder length--->" + jan.ladderLength(beginWord, endWord, wordList));
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
        visited.add(endWord);
        visited.add(beginWord);
        int n = beginWord.length();
        int count = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String word : beginSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < n; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String s = new String(chars);
                        if (endSet.contains(s))
                            return count + 1;
                        if (dict.contains(s) && visited.add(s)) {
                            nextLevel.add(s);
                        }
                    }
                    chars[i] = original;
                }
            }
            beginSet = nextLevel;
            count++;
        }
        return 0;

    }

}
