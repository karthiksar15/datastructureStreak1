import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jun02263 {

    public static void main(String[] args) {
        Jun02263 jun = new Jun02263();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println("threesum--->" + jun.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int k = nums.length - 1;
            int j = i + 1;
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.addAll(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }

        }
        return new ArrayList<>();
    }

}
