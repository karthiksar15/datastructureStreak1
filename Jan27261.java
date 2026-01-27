import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Jan27261 {

    public static void main(String[] args) {
        // int n = 6;
        // List<List<Integer>> edges = List.of(List.of(0, 1), List.of(0, 2), List.of(2,
        // 5), List.of(3, 4), List.of(4, 2));
        int n = 5;
        List<List<Integer>> edges = List.of(List.of(0, 1), List.of(2, 1), List.of(3, 1), List.of(1, 4), List.of(2, 4));
        Jan27261 jan = new Jan27261();
        System.out.println("findSmallestSetOfVertices--->" + jan.findSmallestSetOfVertices(n, edges));
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] cnt = new int[n];
        for (int i = 0; i < edges.size(); i++) {
            cnt[edges.get(i).get(1)]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnt[i] == 0)
                result.add(i);
        }
        return result;
    }

}
