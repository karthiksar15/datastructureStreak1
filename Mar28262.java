public class Mar28262 {

    public static void main(String[] args) {
        // int[] nums = { 1, 2, 4, 5, 6, 3, 1 };
        int[] nums = { 7, 6, 4, 8, 9 };
        Mar28262 mar = new Mar28262();
        System.out.println("first missing positive-->" + mar.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] <= 0 || nums[i] > n) {
                i++;
                continue;
            }
            int index = nums[i] - 1;
            if (nums[i] != nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            } else {
                i++;
            }
        }
        for (int m = 0; m < n; m++) {
            if (nums[m] != m + 1)
                return m + 1;
        }
        return n + 1;
    }

}
