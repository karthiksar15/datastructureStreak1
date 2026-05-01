import java.util.HashSet;
import java.util.Set;

public class Apr2726 {

    public static void main(String[] args) {
        Apr2726 apr = new Apr2726();
        // int[] nums = { 1, 2, 3, 1 };
        // int k = 3;
        int[] nums = { 2, 1, 2 };
        int k = 1;
        System.out.println("duplicate-->" + apr.containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int L = 0;
        for (int R = 0; R < nums.length; R++) {
            if (R - L > k) {
                set.remove(nums[L]);
                L++;
            }
            if (!set.add(nums[R])) {
                return true;
            }
        }
        return false;
    }

    // for (int i = 0; i < nums.length; i++) {
    // int j = 0;
    // int m = i + 1 + j;
    // while (m < nums.length && j < k) {
    // if (nums[i] == nums[m]) {
    // return true;
    // }
    // j++;
    // m++;
    // }
    // }
    // return false;
    // }

}
