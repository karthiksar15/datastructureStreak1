import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dec28 {

    public static void main(String[] args) {
        int[] nums = { 0, 1 };
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        // approach-1
        // int[] arr = new int[2 * nums.length + 1];
        // Arrays.fill(arr, -2);
        // arr[nums.length] = -1;
        // int maxLen = 0;
        // int count = 0;
        // for (int i = 0; i < nums.length; i++) {
        // count = count + (nums[i] == 0 ? -1 : 1);
        // if (arr[count + nums.length] >= -1) {
        // maxLen = Math.max(maxLen, i - arr[count + nums.length]);
        // } else {
        // arr[count + nums.length] = i;
        // }
        // }

        // approach-2
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 0 ? -1 : 1);
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}

