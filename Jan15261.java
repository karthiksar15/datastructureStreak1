import java.util.ArrayList;
import java.util.List;

public class Jan15261 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Jan15261 jan = new Jan15261();
        System.out.println("subsets-->" + jan.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> outputList = new ArrayList<>();
        backtrack(new ArrayList<>(), 0, outputList, nums);
        return outputList;
    }

    public void backtrack(List<Integer> inputList, int index, List<List<Integer>> output, int[] nums) {
        if (index > nums.length) {
            return;
        }
        output.add(new ArrayList<>(inputList));
        for (int j = index; j < nums.length; j++) {
            if (!inputList.contains(nums[j])) {
                inputList.add(nums[j]);
                backtrack(inputList, j + 1, output, nums);
                inputList.remove(inputList.size() - 1);
            }
        }
    }

}
