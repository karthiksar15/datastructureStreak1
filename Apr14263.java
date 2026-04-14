import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Apr14263 {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4 };
        int target = 3;
        Apr14263 apr = new Apr14263();
        System.out.println("twoSum--->" + Arrays.toString(apr.twoSum(numbers, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0, j = numbers.length - 1;

        while (i < j) {
            int sum = numbers[j] + numbers[i];
            if (sum == target) {
                return new int[] { i, j };
            }
            if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        // Map<Integer, Integer> map = new HashMap<>();
        // int sum = 0;
        // for (int i = 0; i < numbers.length; i++) {
        // sum = target - numbers[i];
        // if (map.get(sum) != null)
        // return new int[] { map.get(sum), i + 1 };
        // map.put(numbers[i], i + 1);
        // }
        return result;
    }
}
