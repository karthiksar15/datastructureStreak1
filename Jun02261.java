public class Jun02261 {

    public static void main(String[] args) {
        Jun02261 jun = new Jun02261();
        int[] nums = { 1, 1, 2, 3, 4 };
        System.out.println("remove-->" + jun.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = 1, j = 1;

        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

}
