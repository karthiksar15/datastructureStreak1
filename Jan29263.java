import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Jan29263 {

    public static void main(String[] args) {
        Jan29263 jan = new Jan29263();
        String startGene = "AACCGGTT", endGene = "AAACGGTA";
        String[] bank = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
        System.out.println("number of mutations-->" + jan.minMutation(startGene, endGene, bank));
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> dict = new HashSet<>();
        for (String s : bank) {
            dict.add(s);
        }
        if (!dict.contains(endGene) || startGene.equalsIgnoreCase(endGene))
            return -1;
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        visited.add(endGene);
        Set<String> beginSet = new HashSet<>();
        beginSet.add(startGene);
        Set<String> endSet = new HashSet<>();
        endSet.add(endGene);

        char[] chars = { 'A', 'C', 'G', 'T' };
        int n = startGene.length();
        int score = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = endSet;
                endSet = beginSet;
                beginSet = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String str : beginSet) {
                char[] charArr = str.toCharArray();
                for (int i = 0; i < n; i++) {
                    char original = charArr[i];
                    for (int j = 0; j < chars.length; j++) {
                        if (original == chars[j])
                            continue;
                        charArr[i] = chars[j];
                        String newWord = new String(charArr);
                        if (endSet.contains(newWord))
                            return score;
                        if (dict.contains(newWord) && visited.add(newWord))
                            nextLevel.add(newWord);
                    }
                    charArr[i] = original;
                }
            }
            beginSet = nextLevel;
            score++;
        }
        return -1;

    }

    class Mutate {
        String word;
        int score;

        public Mutate(String word, int score) {
            this.word = word;
            this.score = score;
        }
    }

}
