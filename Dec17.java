public class Dec17 {

    public static void main(String[] args) {
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }

    private static int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            area = Math.max((Math.min(height[left], height[right]) * (right - left)), area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }

}
