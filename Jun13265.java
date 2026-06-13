public class Jun13265 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 0, 1, 0 };
        Jun13265 jun = new Jun13265();
        System.out.println("jump--->" + jun.canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= target) {
                target = i;
            }
        }
        return target == 0;
    }

}
