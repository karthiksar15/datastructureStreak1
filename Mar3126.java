public class Mar3126 {

    public static void main(String[] args) {
        Mar3126 mar = new Mar3126();
        int[] nums = { -1, 0, 2, 4, 6, 8 };
        int target = 10;
        // int[] nums = { 1, 3, 5, 7, 9 };
        // int target = 6;
        System.out.println("insert at--->" + mar.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

}
