import java.util.Arrays;

public class May30266 {

    private int[][] memo;

    public static void main(String[] args) {
        int[] nums = { 3, 4, 3 };
        May30266 may = new May30266();
        System.out.println("rob---->" + may.rob(nums));
    }

    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        memo = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        return Math.max(dfs(nums, 0, 1), dfs(nums, 1, 0));
    }

    public int dfs(int[] nums, int i, int flag) {
        if (i >= nums.length || (flag == 1 && i == nums.length - 1)) {
            return 0;
        }
        if (memo[i][flag] != -1) {
            return memo[i][flag];
        }
        memo[i][flag] = Math.max(dfs(nums, i + 1, flag), nums[i] + dfs(nums, i + 2, (flag == 1 || i == 0) ? 1 : 0));
        return memo[i][flag];
    }

}
