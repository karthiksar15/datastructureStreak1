public class Apr18261 {

    public static void main(String[] args) {
        int[] height = { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 };
        // int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        Apr18261 apr = new Apr18261();
        System.out.println("trap--->" + apr.trap(height));
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }

}
