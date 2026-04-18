class Solution {
    public int maxSubArray(int[] nums) {
        
        int maxSum = nums[0];
        
        for(int i = 0; i < nums.length; i++) {
            int cur = 0;
            
            for(int j = i; j < nums.length; j++) {
                cur += nums[j];
                maxSum = Math.max(maxSum, cur);
            }
        }

        return maxSum;

    }
}
