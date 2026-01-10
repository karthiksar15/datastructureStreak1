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
        Map<Integer, List<Character>> map = new HashMap<>();
        int n = beginWord.length();
        int count = 0;
        if (!wordList.contains(endWord))
            return count;
        for (int i = 0; i < wordList.size(); i++) {
            for (int j = 0; j < n; j++) {
                Character eachChar = wordList.get(i).charAt(j);
                map.computeIfAbsent(j, k -> new ArrayList<>()).add(eachChar);
            }

        }
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(new Vertex(beginWord, count + 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Vertex word = queue.poll();

            if (word.word.equals(endWord))
                return word.count;

            for (int i = 0; i < n; i++) {
                for (char val : map.get(i)) {
                    String newStr = word.word.substring(0, i) + val + word.word.substring(i + 1);
                    if (!visited.contains(newStr) && wordList.contains(newStr)) {
                        queue.add(new Vertex(newStr, word.count + 1));
                        visited.add(newStr);
                    }
                }
            }

        }
        return count;

    }

    class Vertex {
        int count;
        String word;

        public Vertex(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

}
