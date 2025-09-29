import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Jan29Union {

    Set<Integer> seen = new HashSet<>();

    public static void main(String[] args) {
        int[][] edges = { { 0, 1 }, { 1, 2 } };
        int n = 5;
        Jan29Union jan = new Jan29Union();
        System.out.println("comp---" + jan.countComponents(n, edges));
    }

    public int countComponents(int n, int[][] edges) {
        if (n <= 0)
            return 0;
        if (edges == null)
            edges = new int[0][0];
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        int comp = n;
        for (int i = 0; i < edges.length; i++) {
            comp -= union(edges[i][0], edges[i][1], parent, size);
        }

        return comp;
    }

    public int union(int v1, int v2, int[] parent, int[] size) {
        int parentV1 = find(v1, parent);
        int parentV2 = find(v2, parent);
        if (v1 == v2) {
            return 0;
        } else {

            if (size[parentV1] > size[parentV2]) {
                size[parentV1] += size[parentV2];
                parent[parentV2] = parentV1;
            } else {
                size[parentV2] += size[parentV1];
                parent[parentV1] = parentV2;
            }
            return 1;
        }
    }

    public int find(int vertex, int[] parent) {
        if (vertex == parent[vertex])
            return vertex;
        return parent[vertex] = find(parent[vertex], parent);
    }

}

