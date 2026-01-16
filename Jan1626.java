import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jan1626 {

    public static void main(String[] args) {
        int[][] nums = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
        Jan1626 jan = new Jan1626();
        System.out.println("allpaths--->" + jan.allPathsSourceTarget(nums));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] inner = graph[i];
            for (int j = 0; j < inner.length; j++) {
                map.computeIfAbsent(i, k -> new ArrayList<>()).add(inner[j]);
            }
        }
        int target = n - 1;
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        backtrack(map, output, 0, target, curr);
        return output;
    }

    public void backtrack(Map<Integer, List<Integer>> map, List<List<Integer>> ouput, int start, int target,
            List<Integer> curr) {
        if (start == target) {
            ouput.add(new ArrayList<>(curr));
            return;
        }
        if (map.get(start) != null) {
            for (int next : map.get(start)) {
                if (!curr.contains(next)) {
                    curr.add(next);
                    backtrack(map, ouput, next, target, curr);
                    curr.remove(curr.size() - 1);
                }
            }
        }
    }

}
