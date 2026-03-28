public class Mar28261 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 5, 6, 3, 1 };
        Mar28261 mar = new Mar28261();
        System.out.println("first missing positive-->" + mar.firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {

        int max = 0;
        for (int i : nums) {
            max = Math.max(i, max);
        }
        int[] res = new int[max];
        for (int i : nums) {
            if (i > 0)
                res[i - 1] = i;
        }
        for (int i = 1; i < res.length; i++) {
            if (res[i - 1] == 0)
                return i;
        }
        return res.length + 1;
    }

}
