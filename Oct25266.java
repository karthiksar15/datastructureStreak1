public class Oct25266 {

    public static void main(String[] args) {
        Oct25266 oct = new Oct25266();
        int[] nums = { 4, 2, 3, 7 };
        System.out.println("maxCoins-->" + oct.maxCoins(nums));
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for(int i=0;i>=0;i--)
        {
            for(int j=n-)
        }
    }

}
