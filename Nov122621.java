public class Nov122621 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 0, 1 };
        Nov122621 nov = new Nov122621();
        System.out.println("canJump-->" + nov.canJump(nums));
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
