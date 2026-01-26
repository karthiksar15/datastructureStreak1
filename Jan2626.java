import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Jan2626 {

    public static void main(String[] args) {
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        Jan2626 jan = new Jan2626();
        System.out.println("findCircleNum--->" + jan.findCircleNum(isConnected));
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Union uf = new Union(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }

            }
        }
        Set<Integer> parents = new HashSet<>();
        for (int i = 0; i < n; i++) {
            parents.add(uf.findParent(i));
        }
        return parents.size();
    }

    class Union {
        public int len;
        public int[] parent;
        public int[] rank;

        public Union(int len) {
            this.len = len;
            parent = new int[len];
            rank = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < len; i++) {
                rank[i] = 1;
            }
        }

        public int findParent(int child) {
            if (child != parent[child])
                parent[child] = findParent(parent[child]);
            return parent[child];
        }

        public void union(int child1, int child2) {
            int parent1 = findParent(child1);
            int parent2 = findParent(child2);

            if (parent1 != parent2) {
                if (rank[parent1] >= rank[parent2]) {
                    parent[parent2] = parent1;
                    rank[parent1]++;
                } else if (rank[parent2] > rank[parent1]) {
                    parent[parent1] = parent2;
                    rank[parent2]++;
                }
            }
        }
    }

}
