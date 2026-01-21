import java.util.ArrayList;
import java.util.List;

public class Jan2126 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Jan2126 jan = new Jan2126();
        System.out.println("permu---->" + jan.permute(nums));
    }

    // Optimized: use a boolean[] to track used elements to avoid O(n) contains()
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(nums.length), output);
        return output;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> curr, List<List<Integer>> output) {
        if (curr.size() == nums.length) {
            output.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i])
                continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums, used, curr, output);
            curr.remove(curr.size() - 1);
            used[i] = false;
        }
    }
}
