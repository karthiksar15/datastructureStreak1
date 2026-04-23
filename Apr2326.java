public class Apr2326 {

    public static void main(String[] args) {
        Apr2326 apr = new Apr2326();
        int[] height = { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 };
        System.out.println("trapped--->" + apr.trap(height));
    }

    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int sum = 0;
        int leftMax = height[0];
        int rightMax = height[r];
        while (l < r) {
            if (leftMax > rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                sum += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                sum += rightMax - height[r];
            }
        }
        return sum;
    }

}
