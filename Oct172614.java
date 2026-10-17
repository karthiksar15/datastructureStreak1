public class Oct172614 {

    public static void main(String[] args) {
        int[] nums = { 2, 4 };
        Oct172614 oct = new Oct172614();
        System.out.println("subset--->" + oct.subsetXORSum(nums));
    }

    public int subsetXORSum(int[] nums) {
        int res = 0;
        for (int n : nums) {
            res |= n;
        }
        return res << nums.length - 1;
    }

}
