public class May06262 {

    public static void main(String[] args) {
        int[] height = { 0, 2, 0, 3, 1, 0, 1, 3, 2, 1 };
        May06262 may = new May06262();
        System.out.println("trap--->" + may.trap(height));
    }

    public int trap(int[] height) {

        int l = 0, r = height.length - 1, res = 0;
        int maxLeftArea = height[l], maxRightArea = height[r];
        while (l < r) {
            if (maxLeftArea < maxRightArea) {
                l++;
                maxLeftArea = Math.max(maxLeftArea, height[l]);
                res += maxLeftArea - height[l];
            } else {
                r--;
                maxRightArea = Math.max(maxRightArea, height[r]);
                res += maxRightArea - height[r];
            }
        }
        return res;
    }

}
