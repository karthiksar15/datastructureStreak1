import java.util.ArrayList;
import java.util.List;

public class Jan1426 {

    public static void main(String[] args) {
        int[] num = { 1, 2, 3 };
        Jan1426 jan = new Jan1426();
        System.out.println("jan--->" + jan.permute(num));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }

    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num : nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }

}
