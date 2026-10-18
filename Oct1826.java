import java.util.ArrayList;
import java.util.List;

public class Oct1826 {

    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 9 };
        int target = 9;
        Oct1826 oct = new Oct1826();
        System.out.println("combinationSum--->" + oct.combinationSum(nums, target));
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, target, new ArrayList<>(), result, 0);
        return result;
    }

    public void backtrack(int[] nums, int target, List<Integer> list, List<List<Integer>> result, int sum) {
        if (sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i : nums) {
            sum += i;
            if (sum > target) {
                return;
            }
            list.add(i);
            backtrack(nums, target, list, result, sum);
            list.remove(list.size() - 1);
        }
    }

}
