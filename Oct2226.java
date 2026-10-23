import java.util.ArrayList;
import java.util.List;

public class Oct2226 {

    List<List<Integer>> result;

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Oct2226 oct = new Oct2226();
        System.out.println("permute--->" + oct.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> subset, boolean[] pick) {
        if (subset.size() == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!pick[i]) {
                pick[i] = true;
                subset.add(nums[i]);
                backtrack(nums, subset, pick);
                subset.remove(subset.size() - 1);
                pick[i] = false;
            }
        }
    }

}
