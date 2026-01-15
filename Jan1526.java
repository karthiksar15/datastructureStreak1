import java.util.ArrayList;
import java.util.List;

public class Jan1526 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Jan1526 jan = new Jan1526();
        System.out.println("permute--->" + jan.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        backtrack(new ArrayList<>(), outputList, nums);
        return outputList;
    }

    public void backtrack(List<Integer> input, List<List<Integer>> output, int[] nums) {
        if (input.size() == nums.length) {
            output.add(new ArrayList<>(input));
            return;
        }
        for (int k : nums) {
            if (!input.contains(k)) {
                input.add(k);
                backtrack(input, output, nums);
                input.remove(input.size() - 1);
            }
        }
    }

}
