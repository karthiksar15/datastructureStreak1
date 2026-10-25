import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Oct25268 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        Oct25268 oct = new Oct25268();
        System.out.println("subsetsWithDup-->" + oct.subsetsWithDup(nums));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> subset, int[] nums, int i) {
        result.add(new ArrayList<>(subset));
        for (int j = i; j < nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) {
                continue;
            }
            subset.add(nums[j]);
            backtrack(result, subset, nums, j + 1);
            subset.remove(subset.size() - 1);
        }
    }

}
