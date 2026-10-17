public class Oct172615 {

    public static void main(String[] args) {
        int[] nums = { 2, 4 };
        Oct172615 oct = new Oct172615();
        System.out.println("subs--->" + oct.subsetXORSum(nums));
    }

    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0);
    }

    public int dfs(int[] nums, int i, int total) {
        if (i == nums.length) {
            return total;
        }
        return dfs(nums, i + 1, total ^ nums[i]) + dfs(nums, i + 1, total);
    }

}
