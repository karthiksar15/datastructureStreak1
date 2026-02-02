import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Feb02261 {

    public static void main(String[] args) {
        Feb02261 feb = new Feb02261();
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"), List.of("bc", "cd"));
        double[] values = { 1.5, 2.5, 5.0 };
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("c", "b"), List.of("bc", "cd"),
                List.of("cd", "bc"));
        // System.out.println("calcEquation-->" + feb.calcEquation(equations, values,
        // queries));
        Arrays.stream(feb.calcEquation(equations, values, queries)).forEach(System.out::println);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<String, Map<String, Double>> map = new HashMap<>();
        int i = 0;
        for (List<String> eq : equations) {
            map.computeIfAbsent(eq.get(0), k -> new HashMap<>()).put(eq.get(1), values[i]);
            map.computeIfAbsent(eq.get(1), k -> new HashMap<>()).put(eq.get(0), 1 / values[i]);
            i++;
        }
        int j = 0;
        for (List<String> qu : queries) {
            if (qu.get(0).equals(qu.get(1)))
                result[j] = map.get(qu.get(0)).get(qu.get(1));
            else
                result[j] = findResult(qu.get(0), qu.get(1), map, new HashMap<>());
            j++;
        }
        return result;
    }

    public double findResult(String divident, String divisor, Map<String, Map<String, Double>> map,
            Map<String, Double> result) {
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new LinkedList<>();
        visited.add(divident);
        queue.add(divident);
        double res = 1;
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if (temp.equals(divisor)) {
                return result.get(temp);
            }
            for (Entry<String, Double> entry : map.get(temp).entrySet()) {
                if (visited.add(entry.getKey())) {
                    res = res * entry.getValue();
                    result.put(entry.getKey(), res);
                    queue.add(entry.getKey());
                }
            }
        }
        return res;
    }

}
