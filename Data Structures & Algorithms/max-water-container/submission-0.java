class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        for(int l = 0; l < heights.length - 1; l++) {

            for(int r = l + 1; r < heights.length; r++) {
                int rectangleBase = r - l;
                int rectangleHeight = Math.min(heights[r], heights[l]);
                int area = rectangleBase * rectangleHeight;

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }
}
