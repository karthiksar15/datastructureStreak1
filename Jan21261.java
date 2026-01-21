import java.util.ArrayList;
import java.util.List;

public class Jan21261 {

    public static void main(String[] args) {
        Jan21261 jan = new Jan21261();
        int[] nums = { 1, 2, 3 };
        System.out.println("subsets----" + jan.subsets(nums));

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, nums, 0, new ArrayList<>());
        return output;
    }

    public void backtrack(List<List<Integer>> output, int[] nums, int index, List<Integer> curr) {

        output.add(new ArrayList<>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(output, nums, i + 1, curr);
            curr.remove(curr.size() - 1);
        }

    }

}
