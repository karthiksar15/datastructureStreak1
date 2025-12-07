import java.util.ArrayList;
import java.util.List;

public class Feb20 {

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> edges = List.of(List.of(0, 1), List.of(0, 2), List.of(2, 5), List.of(3, 4), List.of(4, 2));
        Feb20 feb = new Feb20();
        System.out.println("set-->" + feb.findSmallestSetOfVertices(n, edges));
    }

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] indgree = new boolean[n];
        List<Integer> setVertices = new ArrayList<>();
        for (List<Integer> vertex : edges) {
            if (!indgree[vertex.get(1)]) {
                indgree[vertex.get(1)] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!indgree[i]) {
                setVertices.add(i);
            }
        }
        return setVertices;
    }

}

