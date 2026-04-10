class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        int left = 0;
        int right = heights.length - 1;

        while(left < right) {
            int base = right - left;
            int h = Math.min(heights[left], heights[right]);
            int area = base * h;
            maxArea = Math.max(maxArea, area);

            if(heights[left] <= heights[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return maxArea;
    }
}
