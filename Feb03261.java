import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Feb03261 {
    public static void main(String[] args) {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"),
                List.of("bc", "cd"));
        double[] values = { 1.5, 2.5, 5.0 };
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("c", "b"),
                List.of("bc", "cd"),
                List.of("cd", "bc"));
        Feb03261 feb = new Feb03261();
        Arrays.stream(feb.calcEquation(equations, values, queries)).forEach(System.out::println);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Arrays.fill(result, -1);
        Map<String, Map<String, Double>> map = new HashMap<>();
        int i = 0;
        for (List<String> eq : equations) {
            String first = eq.get(0);
            String second = eq.get(1);
            map.computeIfAbsent(first, v -> new HashMap()).put(second, values[i]);
            map.computeIfAbsent(second, v -> new HashMap()).put(first, 1 / values[i]);
            i++;
        }
        int j = 0;
        for (List<String> qu : queries) {
            Set<String> visited = new HashSet<>();
            Deque<String> queue = new LinkedList<>();
            String divident = qu.get(0);
            String divisor = qu.get(1);
            if (map.get(divident) == null || map.get(divisor) == null) {
                continue;
            }
            if (divident.equals(divisor)) {
                result[j] = map.get(divident).get(divisor);
                j++;
                continue;
            }
            queue.add(divident);
            double val = 1.0;
            while (!queue.isEmpty()) {
                String temp = queue.poll();
                if (divisor.equals(temp)) {
                    result[j] = val;
                    break;
                }
                for (Map.Entry<String, Double> neigh : map.get(temp).entrySet()) {
                    val = val * neigh.getValue();
                    if (visited.add(neigh.getKey())) {
                        queue.add(neigh.getKey());
                    }
                }
            }
            j++;
        }
        return result;
    }

}
