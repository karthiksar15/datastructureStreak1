import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Feb0826 {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        Feb07265 feb = new Feb07265();
        System.out.println("ladderLength-->" + feb.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return -1;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        visited.add(endWord);
        int res = 1;
        while ((!beginSet.isEmpty()) && (!endSet.isEmpty())) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = endSet;
                endSet = beginSet;
                beginSet = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String str : beginSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (original == c)
                            continue;
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord)) {
                            return res + 1;
                        }
                        if (dict.contains(newWord) && visited.add(newWord)) {
                            nextLevel.add(newWord);
                        }
                    }
                    chars[i] = original;
                }
            }
            beginSet = nextLevel;
            res++;
        }
        return -1;
    }

}
