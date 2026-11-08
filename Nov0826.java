import java.util.Arrays;

public class Nov0826 {

    public static void main(String[] args) {
        Nov0826 nov = new Nov0826();
        int[] nums = { 2, 4, 1, 3, 5 };
        int k = 3;
        System.out.println("canParition--->" + nov.canPartitionKSubsets(nums, k));

    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int tot = 0;
        for (int n : nums) {
            tot += n;
        }
        int n = nums.length;
        if (tot % k != 0)
            return false;
        int target = tot / k;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }
        boolean[] visited = new boolean[n];
        return backtrack(nums, k, 0, visited, 0, target);
    }

    public boolean backtrack(int[] nums, int k, int index, boolean[] visited, int sum,
            int target) {

        if (k == 0)
            return true;
        if (sum == target) {
            return backtrack(nums, k - 1, 0, visited, 0, target);
        }

        for (int j = index; j < nums.length; j++) {
            if (visited[j] || sum + nums[j] > target)
                continue;
            visited[j] = true;
            if (backtrack(nums, k, j + 1, visited, sum + nums[j], target))
                return true;
            visited[j] = false;
            if (sum == 0)
                return false;
        }
        return false;
    }
}
