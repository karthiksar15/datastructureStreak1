public class Jun04265 {

    public static void main(String[] args) {
        Jun04265 jun = new Jun04265();
        int[] nums = { 1, 1, 2, 3, 4 };
        System.out.println("removeDuplicates--->" + jun.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = 1, j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[j - 1]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }

}
