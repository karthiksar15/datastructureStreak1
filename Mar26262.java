import java.util.HashMap;
import java.util.Map;

public class Mar26262 {

    public static void main(String[] args) {
        int[] nums = { 0, 0, -1 };
        Mar26262 mar = new Mar26262();
        System.out.println("longest--->" + mar.longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        boolean[] seen = new boolean[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = 1;
            int temp = nums[i];
            if (!seen[map.get(temp)]) {
                seen[map.get(temp)] = true;
                while (true) {
                    int num1 = temp + 1;
                    int num2 = temp - 1;
                    if (map.containsKey(num1) && (!seen[map.get(num1)])) {
                        j++;
                        temp = num1;
                        seen[map.get(num1)] = true;
                        continue;
                    }
                    if (map.containsKey(num2) && (!seen[map.get(num2)])) {
                        j++;
                        temp = num2;
                        seen[map.get(num2)] = true;
                        continue;
                    }
                    break;
                }
                max = Math.max(max, j);
            }
        }
        return max;
    }

}
