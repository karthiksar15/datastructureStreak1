public class May1526 {

    public static void main(String[] args) {
        May1526 may = new May1526();
        int[] nums = { 3, 4, 5, 6, 1, 2 };
        int target = 1;
        System.out.println("search--->" + may.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[l] <= nums[mid]) {
                if (target > nums[mid] || target < nums[l]) {
                    l = mid + 1;
                } else {
                    h = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[h]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

        }
        return -1;
    }

}
