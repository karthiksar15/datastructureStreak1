public class Sep25261 {

    public static void main(String[] args) {
        Sep25261 sep = new Sep25261();
        int[] nums = { 1, 2, 3, 2, 2 };
        System.out.println("findDuplicate--->" + sep.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        for (int n : nums) {
            int idx = Math.abs(n) - 1;
            if (nums[idx] < 0)
                return n;
            nums[idx] *= -1;
        }
        return -1;
    }

}
