public class Apr1826 {

    public static void main(String[] args) {
        int[] height = { 1, 7, 2, 5, 4, 7, 3, 6 };
        Apr1826 apr = new Apr1826();
        System.out.println("maxArea--->" + apr.maxArea(height));
    }

    public int maxArea(int[] heights) {
        int i = 0;
        int j = heights.length - 1;
        int dist = 0;
        int maxArea = 0;
        while (i < j) {
            int min = Math.min(heights[i], heights[j]);
            dist = min * (j - i);
            if (dist > maxArea) {
                maxArea = dist;
            }
            if (heights[i] < heights[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }

}
