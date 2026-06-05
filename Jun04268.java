import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Jun04268 {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, -3, 1, 0 };
        int target = 3;
        Jun04268 jun = new Jun04268();
        System.out.println("four sum--->" + jun.fourSum(nums, target));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> resuList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        resuList.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return resuList;

    }

}
