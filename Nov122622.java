public class Nov122622 {

    public static void main(String[] args) {
        int[] nums = { 2, 4, 1, 1, 1, 1 };
        Nov122622 nov = new Nov122622();
        System.out.println("jump--->" + nov.jump(nums));
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
