import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Feb0526 {

    public static void main(String[] args) {
        Feb0526 feb = new Feb0526();
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
        for (List<String> eq : equations) {
            map.computeIfAbsent(eq.get(0), v -> new HashMap<>()).put(eq.get(1), values[i]);
            map.computeIfAbsent(eq.get(1), v -> new HashMap<>()).put(eq.get(0), 1 / values[i]);
            i++;
        }

        double[] result = new double[queries.size()];
        Arrays.fill(result, -1);

        int idx = 0;
        for (List<String> qu : queries) {
            String divident = qu.get(0);
            String divisor = qu.get(1);
            Set<String> visited = new HashSet<>();
            Deque<String> queue = new LinkedList<>();
            Map<String, Double> ratioMap = new HashMap<>();
            if (map.get(divident) == null || map.get(divisor) == null) {
                idx++;
                continue;
            }
            if (divident.equals(divisor)) {
                result[idx] = 1;
                continue;
            }
            queue.add(divident);
            visited.add(divident);
            while (!queue.isEmpty()) {
                String temp = queue.poll();
                Double ratio = ratioMap.getOrDefault(temp, 1.0);
                if (temp.equals(divisor)) {
                    result[idx] = ratioMap.get(temp);
                    break;
                }
                for (Map.Entry<String, Double> entry : map.get(temp).entrySet()) {
                    if (visited.add(entry.getKey())) {
                        ratioMap.put(entry.getKey(), (ratio * entry.getValue()));
                        queue.add(entry.getKey());
                    }
                }
            }
            idx++;
        }

        return result;

    }

}
