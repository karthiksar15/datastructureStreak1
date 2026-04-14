public class Apr14262 {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 4 };
        Apr14262 apr = new Apr14262();
        System.out.println("remove duplicates--->" + apr.removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int l = 1;
        int r = 1;
        int len = nums.length;
        while (r < len) {
            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }

}
