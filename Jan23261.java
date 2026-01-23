import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jan23261 {

    public static void main(String[] args) {
        Jan23261 jan = new Jan23261();
        String beginWord = "hit", endWord = "dog";
        List<String> wordList = List.of("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println("ladderLength---->" + jan.ladderLength(beginWord, endWord, wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int transCnt = 1;
        String[] confirm = new String[1];
        confirm[0] = beginWord;
        if (!wordList.contains(endWord))
            return transCnt;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        for (int i = 0; i < beginWord.length(); i++) {
            String newWord = helper(i, wordList, endWord, beginWord, 0, 26, confirm, visited);
            if (newWord.equalsIgnoreCase(endWord))
                break;
            if (!newWord.isBlank()) {
                transCnt++;
                i = -1;
                beginWord = newWord;
            }

        }
        return transCnt;

    }

    public String helper(int len, List<String> wordList, String target, String curr, int stInd, int endInd,
            String[] confirm, Set<String> visited) {
        String result = curr;
        if (stInd == endInd)
            return "";
        if (wordList.contains(curr) && (!visited.contains(curr))) {
            visited.add(curr);
            return curr;
        }

        int chars = 'a' + stInd;
        curr = curr.substring(0, len) + (char) chars + curr.substring(len + 1);
        result = helper(len, wordList, target, curr, stInd + 1, endInd, confirm, visited);

        return result;
    }
}
