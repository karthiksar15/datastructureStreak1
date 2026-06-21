public class Jun1826 {
    public static void main(String[] args) {
        int[] nums = { 2, 4, 1, 1, 1, 1 };
        Jun1826 jun = new Jun1826();
        System.out.println("jump--->" + jun.jump(nums));
    }

    public int jump(int[] nums) {
        int res = 0, l = 0, r = 0;
        while (r < nums.length - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
    }

}
