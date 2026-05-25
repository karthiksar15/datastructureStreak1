public class May2526 {

    public static void main(String[] args) {
        int[] nums = { -1, 0, 2, 4, 6, 8 };
        int target = 4;
        May2526 may = new May2526();
        System.out.println("search--->" + may.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid])
                return mid;
            if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

}
