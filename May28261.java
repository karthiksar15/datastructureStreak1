public class May28261 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 4, 5, 6, 1, 2, 2 };
        int target = 1;
        May28261 may = new May28261();
        System.out.println("search--->" + may.search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[l] < nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else if (nums[l] > nums[mid]) {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                l++;
            }
        }
        return false;
    }

}
