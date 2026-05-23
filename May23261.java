public class May23261 {

    int[] cache;

    public static void main(String[] args) {
        May23261 may = new May23261();
        System.out.println("climbstairs--->" + may.climbStairs(2));
    }

    public int climbStairs(int n) {
        cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return dfs(n, 0);
    }

    public int dfs(int n, int i) {
        if (i >= n)
            return i == n ? 1 : 0;
        if (cache[i] != -1)
            return cache[i];
        return cache[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }

}
