import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Jan11 {
    public static void main(String[] args) {

        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] ans = nextGreaterElement(nums1, nums2);
        for (int an : ans) {
            System.out.println(an);
        }

    }

    // public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
    // Map<Integer, Integer> map = new HashMap<>();
    // int[] output = new int[nums1.length];
    // int i = 0;
    // for (int num : nums2) {
    // int j = i + 1;
    // while (j < nums2.length) {
    // if (nums2[j] > num) {
    // map.put(num, nums2[j]);
    // break;
    // }
    // j++;
    // }
    // i++;
    // }
    // int k = 0;
    // for (int num : nums1) {
    // output[k] = map.get(num) != null ? map.get(num) : -1;
    // k++;
    // }
    // return output;
    // }
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        var greater = findAllGreater(nums2);
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = greater[nums1[i]];
        }
        return nums1;

    }

    private static int[] findAllGreater(int[] nums) {
        int[] output = new int[nums.length + 10];
        Stack<Integer> stack = new Stack();
        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i];
            while (!stack.isEmpty() && stack.peek() < curr)
                stack.pop();
            if (stack.isEmpty())
                output[curr] = -1;
            else
                output[curr] = stack.peek();

            stack.push(nums[i]);

        }
        return output;
    }

}
