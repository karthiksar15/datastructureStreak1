public class Jun0626 {

    public static void main(String[] args) {
        Jun0626 jun = new Jun0626();
        int[] heights = { 1, 7, 2, 5, 4, 7, 3, 6 };
        System.out.println("maxArea--->" + jun.maxArea(heights));
    }

    public int maxArea(int[] heights) {
        int maxArea = 0;
        int l = 0, r = heights.length - 1;
        while (l < r) {
            int min = Math.min(heights[l], heights[r]);
            int dist = (r - l) * min;
            maxArea = Math.max(maxArea, dist);
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

}
