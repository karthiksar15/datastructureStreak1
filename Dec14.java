import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Dec14 {

    public static void main(String[] args) {
        // int[] nums = { 2, 7, 11, 15 };
        // int[] nums = { 3, 2, 4 };
        int[] nums = { 2, 5, 5, 11 };

        // int target = 9;//
        int target = 10;
        IntStream.of(twoSum(nums, target)).forEach(System.out::println);
        System.out.println();

    }

    public static int[] twoSum(int[] nums, int target) {

        // sol:1
        // int[] result = new int[2];
        // int i = 0;
        // int j = nums.length - 1;
        // int sum = 0;
        // while (i != j) {
        // sum = nums[i] + nums[j];
        // if (target == sum) {
        // result[0] = i;
        // result[1] = j;
        // }
        // j--;
        // }
        // return result;
        // sol2
        // int[] result = new int[2];
        // Map<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        // map.put(nums[i], i);
        // }
        // for (int i = 0; i < nums.length; i++) {
        // int compliment = target - nums[i];
        // Integer currentKeyVal = map.get(compliment);
        // if (map.containsKey(compliment) && (i != currentKeyVal)) {
        // result[0] = i;
        // result[1] = map.get(compliment);
        // break;
        // }
        // }
        // return result;
        // sol3
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                return new int[] { map.get(compliment), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }

}
