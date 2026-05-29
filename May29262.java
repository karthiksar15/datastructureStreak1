public class May29262 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 4, 5, 6, 1, 2, 2 };
        int target = 0;
        May29262 may = new May29262();
        System.out.println("search--->" + may.search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
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
