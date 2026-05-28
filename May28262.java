public class May28262 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 10, 1, 5 };
        int k = 2;
        May28262 may = new May28262();
        System.out.println("splitArray--->" + may.splitArray(nums, k));
    }

    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0, res = 0;
        for (int n : nums) {
            l = Math.max(l, n);
            r += n;
        }
        res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canSplit(nums, k, mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public boolean canSplit(int[] nums, int k, int mid) {
        int tot = 0;
        int subarray = 1;
        for (int num : nums) {
            tot += num;
            if (tot > mid) {
                subarray++;
                if (subarray > k)
                    return false;
                tot = num;
            }
        }
        return true;
    }

}
