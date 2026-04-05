public class Apr0526 {

    public static void main(String[] args) {
        Apr0526 apr = new Apr0526();
        int[] nums = { 1, 2, 1, 3, 4 };
        int k = 3;
        System.out.println("subarrays--->" + apr.subarraysWithKDistinct(nums, k));
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atLeast(nums, k) - atLeast(nums, k + 1);
    }

    private int atLeast(int[] nums, int k) {
        int[] count = new int[nums.length + 1];
        int left = 0, total = 0, distinct = 0;

        for (int right = 0; right < nums.length; right++) {
            if (count[nums[right]]++ == 0)
                distinct++;

            while (distinct > k) {
                if (--count[nums[left++]] == 0)
                    distinct--;
            }

            // all subarrays ending at right, starting from left..right are valid
            total += right - left + 1;
        }
        return total;
    }

    // public int subarraysWithKDistinct(int[] nums, int k) {
    // int[] distinctCount = new int[nums.length + 1];
    // int totalCount = 0;
    // int left = 0;
    // int right = 0;
    // int currCount = 0;
    // while (right < nums.length) {
    // if (distinctCount[nums[right++]]++ == 0) {
    // k--;
    // }
    // if (k < 0) {
    // --distinctCount[nums[left++]];
    // k++;
    // currCount = 0;
    // }
    // if (k == 0) {
    // while (distinctCount[nums[left]] > 1) {
    // --distinctCount[nums[left++]];
    // currCount++;
    // }
    // totalCount += (currCount + 1);
    // }
    // }
    // return totalCount;
    // }

}
