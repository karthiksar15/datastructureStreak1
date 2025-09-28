import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Jan28 {

    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> seen = new HashSet<>();

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 4, 5 }, { 5, 6 }, { 6, 4 } };
        Jan28 jan = new Jan28();
        System.out.println(jan.validPath(n, edges, 4, 7));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0)
            return true;
        buildAdjacency(edges, true);
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(source);
        seen.add(source);
        while (!stack.isEmpty()) {
            Integer temp = stack.pop();
            if (temp == destination) {
                return true;
            }
            for (Integer neigh : map.get(temp)) {
                if (!seen.contains(neigh)) {
                    stack.push(neigh);
                    seen.add(neigh);
                }
            }
        }
        return false;
    }

    public void buildAdjacency(int[][] edges, boolean undirected) {
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            if (undirected)
                map.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
    }

}
