class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int current = 0;

        for(int num : nums) {
            current = Math.max(num, current + num);
            maxSum = Math.max(maxSum, current);
        }

        return maxSum;
    }
}
