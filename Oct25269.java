import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oct25269 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2 };
        Oct25269 oct = new Oct25269();
        System.out.println("permuteUnique-->" + oct.permuteUnique(nums));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visit = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), res, visit);
        return res;
    }

    public void backtrack(int[] nums, List<Integer> subset, List<List<Integer>> res, boolean[] visit) {
        if (subset.size() == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (visit[j] || (j > 0 && nums[j] == nums[j - 1] && (!visit[j - 1])))
                continue;
            subset.add(nums[j]);
            visit[j] = true;
            backtrack(nums, subset, res, visit);
            visit[j] = false;
            subset.remove(subset.size() - 1);
        }
    }

}
