class Solution {
    public int maxSubArray(int[] nums) {
        
        int[] clone = nums.clone();

        for(int i = 1; i < nums.length; i++) {
            clone[i] = Math.max(nums[i], nums[i] + clone[i - 1]);
        }

        int maxSum = clone[0];
        for(int num : clone) {
            maxSum = Math.max(maxSum, num);
        }

        return maxSum;
    }
}
