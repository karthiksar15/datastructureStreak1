import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Feb07262 {
    public static void main(String[] args) {
        String startGene = "AACCGGTT", endGene = "AACCGGTA";
        String[] bank = { "AACCGGTA" };
        Feb07262 feb = new Feb07262();
        System.out.println("minMutation found--->" + feb.minMutation(startGene, endGene, bank));
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> dict = new HashSet<>(Arrays.asList(bank));
        if (!dict.contains(endGene))
            return -1;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(startGene);
        Set<String> endSet = new HashSet<>();
        endSet.add(endGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        visited.add(endGene);
        int level = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> tempSet = endSet;
                endSet = beginSet;
                beginSet = tempSet;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String str : beginSet) {
                char[] chars = str.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char original = chars[i];
                    for (char c : List.of('A', 'C', 'G', 'T')) {
                        if (c == original)
                            continue;
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord)) {
                            return level;
                        }
                        if (visited.add(newWord) && dict.contains(newWord)) {
                            nextLevel.add(newWord);
                        }
                    }
                    chars[i] = original;
                }
            }
            beginSet = nextLevel;
            level++;
        }
        return -1;
    }

}
