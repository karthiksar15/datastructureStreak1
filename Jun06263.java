import java.util.Arrays;

public class Jun06263 {

    public static void main(String[] args) {
        int[] cost = { 1, 2, 3 };
        Jun06263 jun = new Jun06263();
        System.out.println("minCost--->" + jun.minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(dfs(cost, memo, 0), dfs(cost, memo, 1));
    }

    public int dfs(int[] cost, int[] memo, int i) {
        if (i >= cost.length)
            return 0;
        if (memo[i] != -1)
            return memo[i];
        memo[i] = cost[i] + Math.min(dfs(cost, memo, i + 1), dfs(cost, memo, i + 2));
        return memo[i];
    }

}
