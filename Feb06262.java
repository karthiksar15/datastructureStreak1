import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Feb06262 {

    public static void main(String[] args) {
        String startGene = "AACCGGTT", endGene = "AACCGGTA";
        String[] bank = { "AACCGGTA" };
        Feb05262 feb = new Feb05262();
        System.out.println("minMutation found--->" + feb.minMutation(startGene, endGene, bank));
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> banks = new HashSet<>(Arrays.asList(bank));
        if (!banks.contains(endGene) || startGene.equals(endGene))
            return -1;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(startGene);
        Set<String> endSet = new HashSet<>();
        endSet.add(endGene);
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        visited.add(endGene);

        int res = 1;
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
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
                    for (char ch : List.of('A', 'C', 'G', 'T')) {
                        if (original == ch)
                            continue;
                        chars[i] = ch;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord))
                            return res;
                        if (visited.add(newWord) && banks.contains(newWord)) {
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
