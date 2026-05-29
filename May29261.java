public class May29261 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 10, 1, 5 };
        int k = 2;
        May29261 may = new May29261();
        System.out.println("splitarrya--->" + may.splitArray(nums, k));
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
        int freq = 1;
        for (int n : nums) {
            tot += n;
            if (tot > mid) {
                freq++;
                if (freq > k) {
                    return false;
                }
                tot = n;
            }
        }
        return true;
    }

}
