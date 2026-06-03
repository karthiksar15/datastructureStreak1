public class Jun03261 {

    public static void main(String[] args) {
        int[] height = { 1, 7, 2, 5, 4, 7, 3, 6 };
        Jun03261 jun = new Jun03261();
        System.out.println("maxArea-->" + jun.maxArea(height));
    }

    public int maxArea(int[] heights) {
        int i = 0, j = heights.length - 1;
        int dis = 0, maxArea = 0;
        while (i < j) {
            int min = Math.min(heights[i], heights[j]);
            dis = min * (j - i);
            if (dis > maxArea)
                maxArea = dis;
            if (heights[i] < heights[j])
                i++;
            else
                j--;
        }
        return maxArea;
    }

}
