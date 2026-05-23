import java.util.Arrays;

public class May23263 {

    int[] memo;

    public static void main(String[] args) {
        int[] cost = { 1, 2, 3 };
        May23263 may = new May23263();
        System.out.println("minCost--->" + may.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(dfs(cost, 0), dfs(cost, 1));
    }

    public int dfs(int[] cost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (memo[i] != -1) {
            return memo[i];
        }
        memo[i] = cost[i] + Math.min(dfs(cost, i + 1), dfs(cost, i + 2));
        return memo[i];
    }

}
