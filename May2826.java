public class May2826 {

    public static void main(String[] args) {
        May2826 may = new May2826();
        int[] nums = { 3, 4, 5, 6, 1, 2 };
        int target = 1;
        System.out.println("search---->" + may.search(nums, target));
    }

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
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
        return res;
    }

}
