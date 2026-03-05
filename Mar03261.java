import java.util.HashMap;
import java.util.Map;

public class Mar0326 {

    public static void main(String[] args) {
        Mar0326 mar = new Mar0326();
        int[] nums = { 5, 5, 1, 1, 1, 5, 5 };
        System.out.println("maj--->" + mar.majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int maj = n / 2;
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maj) {
                return entry.getKey();
            }
        }
        return 1;
    }

}
