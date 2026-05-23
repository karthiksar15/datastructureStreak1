public class May23262 {

    public static void main(String[] args) {
        May23262 may = new May23262();
        int[] cost = { 1, 2, 3 };
        System.out.println("minCostClimbingStairs--->" + may.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    public int dfs(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        return cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
    }

}
