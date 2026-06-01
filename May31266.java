import java.util.Arrays;

public class May31266 {

    public static void main(String[] args) {
        int amount = 4;
        int[] coins = { 1, 2, 3 };
        May31266 may = new May31266();
        System.out.println("change--->" + may.change(amount, coins));
    }

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int[][] memo = new int[coins.length + 1][amount + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(0, amount, coins, memo);
    }

    public int dfs(int i, int a, int[] coins, int[][] memo) {
        if (a == 0)
            return 1;
        if (i >= coins.length)
            return 0;
        if (memo[i][a] != -1)
            return memo[i][a];
        int res = 0;
        if (a >= coins[i]) {
            res = dfs(i + 1, a, coins, memo);
            res += dfs(i, a - coins[i], coins, memo);
        }
        memo[i][a] = res;
        return res;
    }

}
