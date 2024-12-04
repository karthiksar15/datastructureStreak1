public class Dec4 {

    /**
     * The main method of the Dec4 class contains a sample scenario for
     * demonstrating the longestOnes method. It creates an array of
     * ones and zeros and prints the length of the longest subarray with
     * at most k zero elements to the console.
     */
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        int longest = longestOnes(nums, k);
        System.out.println("longest found-->" + longest);
    }

    public static int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, max = 0, count = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

}
