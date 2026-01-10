import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Jan1026 {

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        Jan1026 jan = new Jan1026();
        System.out.println("words count--->" + jan.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord == null || endWord == null)
            return 0;
        if (beginWord.length() != endWord.length())
            return 0;

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return 0;

        int count = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                String word = queue.poll();
                if (word.equals(endWord))
                    return count;
                char[] wordArr = word.toCharArray();
                for (int i = 0; i < wordArr.length; i++) {
                    char original = wordArr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (wordArr[i] == c)
                            continue;
                        wordArr[i] = c;
                        String next = new String(wordArr);
                        if (visited.add(next) && wordList.contains(next)) {
                            queue.add(next);
                        }
                    }
                    wordArr[i] = original;
                }
            }
            count++;
        }
        return count;
    }

}
