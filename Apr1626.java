import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Apr1626 {

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        Apr15261 apr = new Apr15261();
        System.out.println("threesum--->" + apr.threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    k--;
                } else if (sum < 0) {
                    j++;
                } else if (sum == 0) {
                    resultList.add(List.of(i, j, k));
                    j++;
                    k--;
                    while (i > 0 && nums[j] == nums[j - 1]) {
                        j++;
                    }
                }
            }
        }
        return resultList;
    }

}
