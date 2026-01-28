import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jan2826 {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        Jan2826 jan = new Jan2826();
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("ladderLen--->" + jan.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return 0;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        int n = beginWord.length();
        int count = 1;
        Set<String> visited = new HashSet<>();
        visited.add(endWord);
        visited.add(beginWord);
        while ((!beginSet.isEmpty()) && (!endSet.isEmpty())) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = endSet;
                endSet = beginSet;
                beginSet = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String begin : beginSet) {
                char[] chars = begin.toCharArray();
                for (int i = 0; i < n; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == original)
                            continue;
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord))
                            return count + 1;
                        if (dict.contains(newWord) && visited.add(newWord)) {
                            nextLevel.add(newWord);
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
