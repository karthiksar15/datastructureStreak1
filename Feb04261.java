import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Feb04261 {

    public static void main(String[] args) {
        Feb04261 feb = new Feb04261();
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
        int j = 0;
        for (List<String> eq : equations) {
            map.computeIfAbsent(eq.get(0), v -> new HashMap<>()).put(eq.get(1), values[j]);
            map.computeIfAbsent(eq.get(1), v -> new HashMap<>()).put(eq.get(0), 1.0 / values[j]);
            j++;
        }
        double[] result = new double[queries.size()];
        Arrays.fill(result, -1);
        int res = 0;
        for (List<String> str : queries) {
            String divident = str.get(0);
            String divisor = str.get(1);

            Map<String, Double> dividentNullCheck = map.get(divident);
            if (dividentNullCheck == null) {
                res++;
                continue;
            }
            Map<String, Double> divisorNullCheck = map.get(divisor);
            if (divisorNullCheck == null) {
                res++;
                continue;
            }
            if (divident.equals(divisor)) {
                result[res] = 1;
                res++;
                continue;
            }
            Set<String> visited = new HashSet<>();
            Map<String, Double> ratioMap = new HashMap<>();
            Deque<String> queue = new LinkedList<>();
            visited.add(divident);
            queue.add(divident);

            while (!queue.isEmpty()) {
                String newStr = queue.poll();
                double ratio = ratioMap.getOrDefault(newStr, 1.0);
                if (newStr.equals(divisor))
                    result[res] = ratio;
                for (Map.Entry<String, Double> entry : map.get(newStr).entrySet()) {
                    if (visited.add(entry.getKey())) {
                        ratioMap.put(entry.getKey(), (ratio * entry.getValue()));
                        queue.add(entry.getKey());
                    }
                }
            }
            res++;
        }
        return result;
    }

}
