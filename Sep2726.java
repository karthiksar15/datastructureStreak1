class Sep2726 {

    public static void main(String[] args) {
        Sep2726 sep = new Sep2726();
        int[] nums = { 1, 2, 3, 2, 2 };
        System.out.println("find duplicate--->" + sep.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0)
                return Math.abs(idx);
            nums[idx] *= -1;
        }
        return -1;
    }
}