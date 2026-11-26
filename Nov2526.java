public class Nov2526 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 0, 1, 0 };
        Nov2526 nov = new Nov2526();
        System.out.println("canJump--->" + nov.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int res = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= res)
                res = i;
        }
        return res == 0;
    }
}
