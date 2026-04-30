import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Apr26261 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, -3, 1, 0 };
        int target = 3;
        Apr26261 apr = new Apr26261();
        System.out.println("foursum---->" + apr.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target)
                break;
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        result.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return result;
    }

}
