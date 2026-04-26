import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Apr2526 {

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        Apr2526 apr = new Apr2526();
        System.out.println("threesum-->" + apr.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1])
                        j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

}
