import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Jan0726 {
    public static void main(String[] args) {
        String startGene = "AACCGGTT", endGene = "AACCGGTA";
        String[] bank = { "AACCGGTA" };
        Jan0726 jan = new Jan0726();
        System.out.println("minMutation found--->" + jan.minMutation(startGene, endGene, bank));
    }

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> banks = new HashSet<>();
        for (String ban : bank) {
            banks.add(ban);
        }
        if (!banks.contains(endGene))
            return -1;
        queue.add(startGene);
        visited.add(startGene);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String temp = queue.poll();
                if (endGene.equals(temp))
                    return count;
                for (String neigh : findNeigh(temp, visited)) {
                    if (!visited.contains(neigh)) {
                        visited.add(neigh);
                        queue.add(neigh);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    public List<String> findNeigh(String gene, Set<String> visited) {
        char[] mutation = { 'A', 'C', 'G', 'T' };
        List<String> mutations = new ArrayList<>();
        for (int i = 0; i < gene.length(); i++) {
            for (char c : mutation) {
                if (gene.charAt(i) != c) {
                    String temp = gene.substring(0, i) + c + gene.substring(i + 1);
                    if (!visited.contains(temp))
                        mutations.add(temp);
                }
            }
        }
        return mutations;
    }

}
