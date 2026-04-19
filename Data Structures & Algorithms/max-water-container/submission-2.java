class Solution {
    public int maxArea(int[] heights) {
        
        // base = R - L
        // height = Math.min(heights[R], heights[L])
        // area = base * height

        int maxArea = 0;

        int L = 0;
        int R = heights.length - 1;

        while(L < R) {

            int base = R - L;
            int height = Math.min(heights[L], heights[R]);

            maxArea = Math.max(maxArea, base * height);

            if(heights[L] < heights[R]) {
                L++;
            }
            else {
                R--;
            }
        }

        return maxArea;
    }
}
