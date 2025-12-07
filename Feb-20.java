public class Feb22 {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        int source = 0;
        int destination = 2;
        Feb21 feb = new Feb21();
        System.out.println("valid path---->" + feb.validPath(n, edges, source, destination));
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        UnionAndFind uf = new UnionAndFind(n);
        for (int i = 0; i < edges.length; i++) {
            uf.union(edges[i][0], edges[i][1]);
        }
        return uf.findParent(source).equals(uf.findParent(destination));
    }

    class UnionAndFind {
        private int[] parent;
        private int[] rank;

        public UnionAndFind(int len) {
            parent = new int[len];
            rank = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < len; i++) {
                rank[i] = 1;
            }
        }

        public Integer findParent(int u) {
            if (u != parent[u])
                parent[u] = findParent(parent[u]);
            return parent[u];
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

