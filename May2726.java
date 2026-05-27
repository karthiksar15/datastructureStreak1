public class May2726 {

    public static void main(String[] args) {
        May2726 may = new May2726();
        // int[] nums = { 1, 3, 1, 1, 1, 1 };
        // int target = 3;
        int[] nums = { 1, 0, 1, 1, 1, 1 };
        int target = 0;
        System.out.println("search--->" + may.search(nums, target));
    }

    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target)
                return true;
            if (nums[l] < nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (nums[l] > nums[m]) {
                if (nums[m] < target && target < nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                l++;
            }
        }
        return false;
    }

}
