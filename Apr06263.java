import java.util.HashSet;
import java.util.Set;

public class Apr06263 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;
        Apr06263 apr = new Apr06263();
        System.out.println("subarrays---->" + apr.subarraysWithKDistinct(nums, k));
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            set.add(nums[right]);
            if (set.size() == k) {
                int temp = right;
                while (temp < nums.length && set.size() == k) {
                    count++;
                    temp++;
                    if (temp < nums.length)
                        set.add(nums[temp]);
                }
                if (temp < nums.length)
                    set.remove(nums[temp]);
                set.remove(nums[left]);
                left++;
            }

        }
        return count;

    }

}
