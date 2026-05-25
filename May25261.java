public class May25261 {

    public static void main(String[] args) {
        int[] nums = { -1, 0, 2, 4, 6, 8 };
        int target = 5;
        May25261 may = new May25261();
        System.out.println("searchInsert--->" + may.searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

}
