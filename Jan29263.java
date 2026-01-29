import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Jan29263 {

    public static void main(String[] args) {
        Jan29263 jan = new Jan29263();
        String startGene = "AACCGGTT", endGene = "AACCGGTA";
        String[] bank = { "AACCGGTA" };
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
        Deque<Mutate> queue = new LinkedList<>();
        queue.add(new Mutate(startGene, 0));
        char[] chars = { 'A', 'C', 'G', 'T' };
        while (!queue.isEmpty()) {
            Mutate temp = queue.poll();
            if (temp.word.equalsIgnoreCase(endGene))
                return temp.score;
            if (temp.score < temp.word.length()) {
                for (int i = 0; i < chars.length; i++) {
                    char[] toChar = temp.word.toCharArray();
                    if (toChar[temp.score] == chars[i])
                        continue;
                    toChar[temp.score] = chars[i];
                    String mutatedStr = new String(toChar);
                    if (visited.add(mutatedStr)) {
                        queue.add(new Mutate(mutatedStr, temp.score + 1));
                    }
                }
            }

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
