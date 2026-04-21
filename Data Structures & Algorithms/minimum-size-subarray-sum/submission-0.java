class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minimalLength = Integer.MAX_VALUE;
        int sum = 0;

        int l = 0;
        for(int r = 0; r < nums.length; r++) {
            
            sum += nums[r];

            while(sum >= target) {
                sum -= nums[l];
                minimalLength = Math.min(minimalLength, r - l + 1);
                l++;
            }
        }

        return minimalLength == Integer.MAX_VALUE ? 0 : minimalLength;
    }
}