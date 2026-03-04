public class Mar0226 {
    public static void main(String[] args) {
        Mar0226 mar = new Mar0226();
        int[] nums = { 1, 1, 2, 3, 4 };
        int val = 1;
        System.out.println("remove element--->" + mar.removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
