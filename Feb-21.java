import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Feb23 {

    public static void main(String[] args) {
        int n = 5;
        // int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        int[][] edges = { { 0, 1 }, { 0, 4 }, { 1, 4 }, { 2, 3 } };
        Feb23 feb = new Feb23();
        System.out.println("number of compo---" + feb.countComponents(n, edges));
    }

    public int countComponents(int n, int[][] edges) {
        UnionAndFind uf = new UnionAndFind(n);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
            map.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        int count = 0;
        Set<Integer> parents = new HashSet<Integer>();
        for (Integer child : map.keySet()) {
            if (!parents.contains(uf.findParent(child))) {
                count++;
                parents.add(uf.findParent(child));
            }

        }
        return map.keySet().size() == n ? count : count + (n - map.keySet().size());
        // return count;
    }

    class UnionAndFind {
        private int[] parent;
        private int[] rank;

        public UnionAndFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int findParent(int x) {
            if (x != parent[x]) {
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int parentX = findParent(x);
            int parentY = findParent(y);
            if (parentX == parentY)
                return;
            if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
            } else if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
            } else {
                parent[parentY] = parentX;
                rank[parentX]++;
            }
        }
    }

}

