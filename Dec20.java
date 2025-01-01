import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dec20 {

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> seen = new HashMap<>();
        Set<List<Integer>> res = new HashSet<>();
        Set<Integer> dups = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (dups.add(nums[i])) {
                for (int j = i + 1; j < nums.length; j++) {
                    int compliment = -nums[i] - nums[j];
                    if (seen.containsKey(compliment) && seen.get(compliment) == i) {
                        var list = Arrays.asList(nums[j], nums[i], compliment);
                        Collections.sort(list);
                        res.add(list);
                    }
                    seen.put(nums[j], i);
                }
            }
        }
        return new ArrayList<>(res);
    }

}
