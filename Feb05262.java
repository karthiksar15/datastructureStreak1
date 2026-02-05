import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Feb05262 {

    public static void main(String[] args) {
        String startGene = "AACCGGTT", endGene = "AACCGGTA";
        String[] bank = { "AACCGGTA" };
        Feb05262 feb = new Feb05262();
        System.out.println("minMutation found--->" + feb.minMutation(startGene, endGene, bank));

    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> banks = new HashSet<>(Arrays.asList(bank));
        if (!banks.contains(endGene))
            return -1;
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(startGene);
        visited.add(startGene);
        int res = 0;
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if (temp.equals(endGene))
                return res;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] chars = temp.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char original = chars[j];
                    for (char c : List.of('A', 'C', 'G', 'T')) {
                        if (chars[j] == c)
                            continue;
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (visited.add(newWord) && banks.contains(newWord)) {
                            queue.add(newWord);
                        }
                    }
                    chars[j] = original;
                }
            }
            res++;
        }

        return res;
    }

}
