import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Jan0626 {
    Map<String, Map<String, Double>> graph = new HashMap<>();

    public static void main(String[] args) {
        List<List<String>> equations = List.of(List.of("a", "b"), List.of("b", "c"));
        double[] values = { 2.0, 3.0 };
        List<List<String>> queries = List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"),
                List.of("x", "x"));
        Jan0626 jan = new Jan0626();
        Arrays.stream(jan.calcEquation(equations, values, queries))
                .forEach(k -> System.out.println("values are-->" + k));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] results = new double[queries.size()];
        for (int i = 0; i < equations.size(); i++) {
            graph.computeIfAbsent(equations.get(i).get(0), k -> new HashMap<>()).put(equations.get(i).get(1),
                    values[i]);
            graph.computeIfAbsent(equations.get(i).get(1), k -> new HashMap<>()).put(equations.get(i).get(0),
                    1 / values[i]);
        }
        for (int i = 0; i < queries.size(); i++) {
            results[i] = fetchValues(queries.get(i).get(0), queries.get(i).get(1));
        }
        return results;
    }

    public double fetchValues(String start, String end) {
        if (!graph.containsKey(start) || (!graph.containsKey(end)))
            return -1;
        Set<String> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 1));
        visited.add(start);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            String label = temp.label;
            double ratio = temp.ratio;
            if (label.equals(end))
                return ratio;
            for (String neigh : graph.get(label).keySet()) {
                if (!visited.contains(neigh)) {
                    visited.add(neigh);
                    queue.add(new Node(neigh, ratio * graph.get(label).get(neigh)));
                }

            }
        }
        return -1;
    }

    class Node {
        String label;
        double ratio;

        public Node(String label, double ratio) {
            this.label = label;
            this.ratio = ratio;
        }
    }

}
