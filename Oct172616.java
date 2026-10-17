import java.util.ArrayList;
import java.util.List;

public class Oct172616 {
    int res = 0;

    public static void main(String[] args) {
        int[] nums = { 2, 4 };
        Oct172616 oct = new Oct172616();
        System.out.println("subset--->" + oct.subsetXORSum(nums));
    }

    public int subsetXORSum(int[] nums) {
        backtrack(0, nums, new ArrayList<>());
        return res;
    }

    public void backtrack(int i, int[] nums, List<Integer> subset) {
        int xor = 0;
        for (int n : subset) {
            xor ^= n;
        }
        res += xor;
        for (int j = i; j < nums.length; j++) {
            subset.add(nums[j]);
            backtrack(j + i, nums, subset);
            subset.remove(subset.size() - 1);
        }
    }

}
