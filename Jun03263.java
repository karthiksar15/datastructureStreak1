public class Jun03263 {

    public static void main(String[] args) {
        int[] height = { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 };
        Jun03263 jun = new Jun03263();
        System.out.println("trap--->" + jun.trap(height));
    }

    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int maxLeft = height[i], maxRight = height[j], res = 0;
        while (i < j) {
            if (maxLeft < maxRight) {
                i++;
                maxLeft = Math.max(maxLeft, height[i]);
                res += maxLeft - height[i];
            } else {
                j--;
                maxRight = Math.max(maxRight, height[j]);
                res += maxRight - height[j];
            }
        }
        return res;
    }

}
