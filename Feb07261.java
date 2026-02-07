import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class Feb07261 {
    public static void main(String[] args) {
        Feb07261 feb = new Feb07261();
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"),
                List.of("bc", "cd"));
        double[] values = { 1.5, 2.5, 5.0 };
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("c", "b"),
                List.of("bc", "cd"),
                List.of("cd", "bc"));
        Arrays.stream(feb.calcEquation(equations, values, queries)).forEach(System.out::println);
        System.out.println("calcEquation--->" + feb.calcEquation(equations, values, queries));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        int i = 0;
        for (List<String> list : equations) {
            map.computeIfAbsent(list.get(0), k -> new HashMap<>()).put(list.get(1), values[i]);
            map.computeIfAbsent(list.get(1), k -> new HashMap<>()).put(list.get(0), 1 / values[i]);
            i++;
        }
        double[] result = new double[queries.size()];
        Arrays.fill(result, -1);
        int k = 0;
        for (List<String> qu : queries) {
            String divident = qu.get(0);
            String divisor = qu.get(1);
            if (map.get(divident) == null || map.get(divisor) == null) {
                k++;
                continue;
            }
            if (divident.equals(divisor)) {
                k++;
                result[k] = 1;
                continue;
            }
            Queue<String> queue = new LinkedList<>();
            queue.add(divident);
            Set<String> visited = new HashSet<>();
            visited.add(divident);
            Map<String, Double> ratioMap = new HashMap<>();
            while (!queue.isEmpty()) {
                String temp = queue.poll();
                double ratio = ratioMap.getOrDefault(temp, 1.0);
                if (temp.equals(divisor)) {
                    result[k] = ratio;
                    break;
                }
                for (Entry<String, Double> entry : map.get(temp).entrySet()) {
                    if (visited.add(entry.getKey())) {
                        queue.add(entry.getKey());
                        ratioMap.put(entry.getKey(), ratio * entry.getValue());
                    }
                }
            }
            k++;
        }
        return result;
    }
}
