import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mar27261 {

    public static void main(String[] args) {
        Mar27261 mar = new Mar27261();
        int[] nums = { 5, 2, 3, 2, 2, 2, 2, 5, 5, 5 };
        System.out.println("majority--->" + mar.majorityElement(nums));
    }

    public List<Integer> majorityElement(int[] nums) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int maj = n / 3;
        for (int i = 0; i < n; i++) {
            if (!result.contains(nums[i])) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (map.get(nums[i]) > maj)
                    result.add(nums[i]);
            }
        }
        return result;
    }

}
