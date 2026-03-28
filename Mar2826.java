import java.util.HashMap;
import java.util.Map;

public class Mar2826 {

    public static void main(String[] args) {
        Mar2826 mar = new Mar2826();
        int[] nums = { 2, -1, 1, 2 };
        System.out.println("subarray-->" + mar.subarraySum(nums, 2));
    }

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        int sum = 0, res = 0;
        for (int i : nums) {
            sum += i;
            int diff = sum - k;
            res += prefixSum.getOrDefault(diff, 0);
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        return res;

    }

}
